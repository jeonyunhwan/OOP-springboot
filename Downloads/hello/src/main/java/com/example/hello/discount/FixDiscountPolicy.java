package com.example.hello.discount;

import com.example.hello.member.Grade;
import com.example.hello.member.Member;

public class FixDiscountPolicy implements DisCountPolicy{

    private  int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {

        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }

        return 0;
    }
}
