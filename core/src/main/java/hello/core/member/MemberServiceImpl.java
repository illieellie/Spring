package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    // 해당 예제의 문제점
    // 다른 저장소로 변경할 때 OCP 원칙을 잘 준수할까?, DIP를 잘 지키고 있나?
    // MemberServiceImpl은 왼쪽 추상화에도 의존하고 오른쪽 구현체에도 의존함
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
