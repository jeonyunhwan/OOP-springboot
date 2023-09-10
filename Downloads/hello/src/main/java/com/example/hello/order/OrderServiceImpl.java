package com.example.hello.order;

import com.example.hello.discount.DisCountPolicy;
import com.example.hello.discount.FixDiscountPolicy;
import com.example.hello.discount.RateDiscountPolicy;
import com.example.hello.member.Member;
import com.example.hello.member.MemberRepository;
import com.example.hello.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /*
    처음 고정 할인이 되어 있는 것을 변경해야 한다.
    private final DisCountPolicy disCountPolicy = new FixDiscountPolicy();

    클래스의 의존 관계에서 추상 클래스 뿐만 아니라 구현체 클래스에도 의존하고 있는 상황
    - > DIP 위반 하고 있다.
     */

    private final DisCountPolicy disCountPolicy = new RateDiscountPolicy();
    /*

     */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        // 단일 책임의 원칙을 준수함.
        Member member = memberRepository.findById(memberId);
        int discountPrice = disCountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
