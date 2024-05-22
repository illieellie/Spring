package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {


        //MemberService memberService = new AppConfig().memberService();

        // AppConfig에 있는 @Bean 환경 설정 정보를 가지고 스프링이 스프링컨테이너에 객체 생성을 하고 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        // AppConfig 메서드이름과 getBean에 꺼낼 메서드 일치시키기

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new mem : " + member.getName());
        System.out.println("find mem : " + findMember.getName());
    }
}