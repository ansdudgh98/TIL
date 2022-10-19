package hello.coreRe2.discount;

import hello.coreRe2.member.Member;

public interface DiscountPolicy {

    int discount(Member member,int price);


}
