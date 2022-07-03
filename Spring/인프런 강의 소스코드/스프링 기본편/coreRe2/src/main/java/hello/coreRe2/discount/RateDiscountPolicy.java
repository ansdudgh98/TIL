package hello.coreRe2.discount;

import hello.coreRe2.annotation.MainDiscountPolicy;
import hello.coreRe2.member.Grade;
import hello.coreRe2.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 20;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP){
            return price* discountPercent/100;
        }else{
            return 0;
        }

    }
}
