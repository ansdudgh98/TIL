package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();


    @RequestMapping("/new-form")
    public ModelAndView newForm(){
        return new ModelAndView("new-form");
    }

    // 더이상 호출할것이 없으니까
    @RequestMapping
    public ModelAndView members(Map<String, String> paramMap) {
        List<Member> members = memberRepository.findAll();
        ModelAndView mv = new ModelAndView("members");
        mv.addObject("members",members);
        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView save(Map<String, String> paramMap) {
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
