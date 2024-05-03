package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // callback 메서드 : 메서드 끝날떄마다 수행
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
    Member member = new Member();
    member.setName("spring");
    repository.save(member);
    Member result = repository.findById(member.getId()).get();
    System.out.println("result : " + (result==member));
        Assertions.assertEquals(member, result);
    }


    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);


        Member result = repository.findByName("spring1").get();
        org.assertj.core.api.Assertions.assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member(); // 초기화 안 해도 에러는 안 남 이클립스에서 실습 한번 해보기
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        org.assertj.core.api.Assertions.assertThat(result).hasSize(2);

    }




}
