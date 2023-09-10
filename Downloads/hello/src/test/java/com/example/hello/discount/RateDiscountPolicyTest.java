package com.example.hello.discount;

import com.example.hello.member.Grade;
import com.example.hello.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        // given
        Member member = new Member(1L, "MEMBER_VIP", Grade.VIP);
        // when
        int discount = discountPolicy.discount(member,10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되어야 하지 않는다.")
    void vip_x(){
        // given
        Member member = new Member(1L, "MEMBER_Basic", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(member,10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }
}