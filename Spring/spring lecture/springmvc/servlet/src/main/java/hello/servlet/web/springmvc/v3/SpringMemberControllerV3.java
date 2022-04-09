package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.Member;
import hello.servlet.domain.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
//단점
//get,Post를 구분하지 않았음



@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();


    @GetMapping("/new-form")
    public String newForm(){
        return "new-form";
    }

    // 더이상 호출할것이 없으니까
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("member",members);
        return "members";
    }

    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {
        Member member = new Member(username,age);
        memberRepository.save(member);

        model.addAttribute("member",member);
        return "save-result";
    }



}
