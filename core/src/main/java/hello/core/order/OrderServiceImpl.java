package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemberRepository;
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
       Member member = memberRepository.findById(memberId);
       int discountPrice = discountPolicy.discoount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
