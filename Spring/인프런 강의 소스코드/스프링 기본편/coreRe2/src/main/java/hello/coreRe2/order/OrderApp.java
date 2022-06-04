package hello.coreRe2.order;

import hello.coreRe2.AppConfig;
import hello.coreRe2.member.Grade;
import hello.coreRe2.member.Member;
import hello.coreRe2.member.MemberService;
import hello.coreRe2.member.MemberServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
    }
}
