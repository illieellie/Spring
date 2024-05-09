package hello.hellospring.service;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MemberServiceTest {

    // Test명은 한글로 적어도됨

    MemberService memberService = new MemberService();

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("Hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        /* using-try-catch
        try {
            memberService.join(member1);
            memberService.join(member1);
            //fail();
        }catch (IllegalStateException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */
        // using lamda
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,()->memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // Exception이 발생해야함, ()-> 메소드를 수행할때

        //then

    }
    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}