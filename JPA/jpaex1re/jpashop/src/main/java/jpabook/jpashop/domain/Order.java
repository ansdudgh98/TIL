package jpabook.jpashop.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity
@Setter
@Getter
@Table(name = "orders") //관례로 인하여 order로 되면 sql예약어 하고 겹치게 됨
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;


    // 외래키를 가지고 있는 쪽이 연관관계의 주인이다.// 실제 코드 작성시에는 단방향 연관관계를 사용할 것
    //연관관계의 주인을 가지고 있는 쪽만 수정이 가능하고 주인이 반대쪽은 읽기만 가능
    @ManyToOne(cascade = CascadeType.ALL,fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //하이버네이트가 자동으로 지원해서 애노테이션을 사용하지 않아도 됨
    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    //타입지정?....  Orinal로 하게되면 정수형으로 저장이 되기때문에 enum을 추가하게 될 경우 오류가 생김
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToOne(fetch = LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    //===연관관계 편의 메서드===///


    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }
    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //==생성 메서드 ==//
    public static Order createOrder(Member member,Delivery delivery,OrderItem... orderItems){
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setOrderStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    //==비즈니스 로직==//
    /**
     * 주문취소
     */
    public void cancel(){
        if(delivery.getDeliveryStatus() == DeliveryStatus.COMP){
            throw new IllegalStateException("이미 배송 완료된 상품은 취소가 불가능합니다.");
        }
        this.setOrderStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }

    }

    //==조회 로직==//

    /**
     * 전제 주문 가격 조회
     */
    public int getTotalPrice(){
        int totalPrice = 0 ;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalPrice();
        }
        return totalPrice;
    }
}
