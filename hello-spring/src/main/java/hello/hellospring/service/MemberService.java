package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// @애노테이션으로 인해 Spring Container에 Service를 등록해줌
// @Service

// JPA 데이터를 저장하거나 변경할때 Transactional 애노테이션 필요
@Transactional
public class MemberService {


    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    // 외부에서 넣어줄 수 있도록 변경
    // * 내가 직접 생성하지 않고 외부에서 넣어줌 (DI : Dependancy Injection)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 회원 가입
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 X.

        // null 이 반환될 가능성이 있으면 Optional로 한번 감싸서 반환 (if문을 사용할 필요가 없어짐)

        // 아래와 같이 Optional 형을 바로 꺼내는 것을 권장하지 않음
        // Optional<Member> result =  memberRepository.findByName(member.getName());

        // 따라서 아래와 같이 작성
        validateDuplicateMember(member); // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                    // member에 값이 있으면 수행 : 예외 발생
        });
    }


    public List<Member> findMembers() {
        // 전체 회원 조회
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
