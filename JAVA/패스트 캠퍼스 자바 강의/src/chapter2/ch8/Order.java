package chapter2.ch8;

//패스트 캠퍼스 객체 복습합시다 문제 2


public class Order {
    public int orderId;
    public String phoneNumber;
    public String Address;
    public String orderdate;
    public int price;
    public String menuId;

    public Order(int orderID,String phoneNumber,String Address,String orderdate,int price,String menuId){
        System.out.println("주문 접수 번호:"+orderID);
        System.out.println("주문 핸드폰 번호:"+phoneNumber);
        System.out.println("주문 집 주소:"+Address);
        System.out.println("주문 날짜:"+orderdate);
        System.out.println("주문 가격:"+price);
        System.out.println("메뉴 번호:"+menuId);
    }

    public static void main(String[] args) {

        Order order = new Order(1111,"0101234567","경기도 000 000","20001010",10000,"1000");

    }


}

