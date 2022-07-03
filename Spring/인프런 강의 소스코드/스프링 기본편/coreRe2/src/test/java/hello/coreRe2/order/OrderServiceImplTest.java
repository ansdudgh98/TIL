package hello.coreRe2.order;

import hello.coreRe2.discount.FixDiscountPolicy;
import hello.coreRe2.member.Grade;
import hello.coreRe2.member.Member;
import hello.coreRe2.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {


    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,new FixDiscountPolicy());
        Order order = orderService.createOrder(1L,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
