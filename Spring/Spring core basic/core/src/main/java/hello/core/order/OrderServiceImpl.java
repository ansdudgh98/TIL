package hello.core.order;

import hello.core.discount.Discountpolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private Discountpolicy discountpolicy;

    public OrderServiceImpl(MemberRepository memberRepository, Discountpolicy discountpolicy) {
        this.memberRepository = memberRepository;
        this.discountpolicy = discountpolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findByID(memberId);
        int discountPrice = discountpolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
