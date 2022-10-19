package hello.coreRe2;

import hello.coreRe2.discount.DiscountPolicy;
import hello.coreRe2.discount.FixDiscountPolicy;
import hello.coreRe2.discount.RateDiscountPolicy;
import hello.coreRe2.member.MemberRepository;
import hello.coreRe2.member.MemberService;
import hello.coreRe2.member.MemberServiceImpl;
import hello.coreRe2.member.MemoryMemberRepository;
import hello.coreRe2.order.OrderService;
import hello.coreRe2.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        System.out.println("AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
