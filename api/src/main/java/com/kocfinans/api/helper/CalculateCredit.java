package com.kocfinans.api.helper;

import lombok.Data;

@Data
public class CalculateCredit {

    private static  final int creditLimitMultiplier = 4;
    private static final float minLimit=10000;

    public static float calculate(int score,float monthlyIncome){

        if (score<500){
            return 0;
        }
        else if (score<1000&&monthlyIncome<5000){
            return minLimit;
        }
        else{
            return monthlyIncome*creditLimitMultiplier;
        }
    }
}
