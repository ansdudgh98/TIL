package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    //수정자 주입(setter)
//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //@Autowired //생성자가 없어도 자동으로 DI시켜줌 생성자가 하나이기 때문에 생략 가능
    //lombok 라이브러리로 생성자 생성
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    //수정자 주입(setter)
//
//    public void setMemberRepository(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }
//
//    public void setDiscountPolicy(DiscountPolicy discountPolicy){
//        this.discountPolicy=discountPolicy
//    }
//

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }


    //테스트용
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
