package com.example.hello.discount;

import com.example.hello.member.Member;

public interface DisCountPolicy {
    /**
     *
     * @Return 할인 대상 금액
     *
     */
    int discount(Member member, int price);

}
