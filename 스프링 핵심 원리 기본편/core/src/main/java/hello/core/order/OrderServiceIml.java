package hello.core.order;

import hello.core.discount.Discountpolicy;
import hello.core.discount.FixDiscountpolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceIml implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final Discountpolicy discountpolicy = new FixDiscountpolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountpolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
