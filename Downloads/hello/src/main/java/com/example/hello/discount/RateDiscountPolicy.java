package com.example.hello.discount;

import com.example.hello.member.Grade;
import com.example.hello.member.Member;

public class RateDiscountPolicy implements DisCountPolicy{
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }

        return 0;
    }
}