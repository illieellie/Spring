package hello.hellospring.controller;

import org.springframework.ui.Model;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class MemberController {

    // 아래와 같이 MemberService 객체를 여러개 생성할 필요없고, 하나만 생성해서 공유를 하려고 함
    //private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    @Autowired  //spring container 가 뜰때 가지고 있던 memberService와 연결을 시켜줌 (DI 의존 관계를 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
