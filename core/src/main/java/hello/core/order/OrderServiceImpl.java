package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
// 필요한것의 생성자를 만들겠다 -> final 필드의 생성자 자동 생성
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

//    @Autowired
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }
    // 아래와 같이 코드를 수정해서 정책을 바꿀 수 있음
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    // OCP, DIP와 같은 객체지향 설계 원칙을 준수했을까?
    // DIP 위배 -> OderServiceImpl(주문 서비스 클라이언트)는 추상(인터페이스)뿐만 아니라 구현체 클래스에도 의존하고 있다.
    // OCP 위배 -> 정책을 변경하려면 클라이언트 코드도 수정이 필요하여 위배


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
       Member member = memberRepository.findById(memberId);
       int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
