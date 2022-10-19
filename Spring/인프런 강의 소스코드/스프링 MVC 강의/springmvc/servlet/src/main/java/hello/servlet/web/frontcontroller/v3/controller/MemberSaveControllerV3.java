package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        System.out.println("------param map --------");
        System.out.println(paramMap);
        System.out.println("paramap username:"+paramMap.get("username"));
        System.out.println("paramap age:"+paramMap.get("age"));
        System.out.println("------------------------");
        Member member = new Member(username,age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member",member);
        return mv;
    }
}
