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

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
