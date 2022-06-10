package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

public class SpringMemberSaveControllerV1 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        System.out.println("------param map --------");
        System.out.println(paramMap);
        System.out.println("paramap username:"+paramMap.get("username"));
        System.out.println("paramap age:"+paramMap.get("age"));
        System.out.println("------------------------");
        Member member = new Member(username,age);
        memberRepository.save(member);

        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member",member);
        return mv;
    }
}
