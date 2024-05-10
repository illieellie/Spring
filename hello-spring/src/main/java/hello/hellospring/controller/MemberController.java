package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // 아래와 같이 MemberService 객체를 여러개 생성할 필요없고, 하나만 생성해서 공유를 하려고 함
    //private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    @Autowired  //spring container 가 뜰때 가지고 있던 memberService와 연결을 시켜줌 (DI 의존 관계를 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


}
