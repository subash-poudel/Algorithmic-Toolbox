package com.subash.poudel.week2;

public class GreatestCommonDivisor {

    private GreatestCommonDivisor(){}

    public static void testGetGCD() {
        String status = getGCD(18, 35) == 1 ? "Success" : "Fail";
        System.out.println(status);
        String status1 = getGCD(18, 35) == 1 ? "Success" : "Fail";
        System.out.println(status1);
    }

//    Problem Description
//    Task. Given two integers a and b, find their greatest common divisor.
//
//    Input Format. The two integers a, b are given in the same line separated by space.
//
//    Constraints. 1 ≤ a, b ≤ 2 · 10 9 .
//
//    Sample 1.
//    Input: 18 35
//    Output: 1
//
//    Sample 2.
//    Input: 28851538 1183019
//    Output: 17657

    public static int getGCD(int a, int b) {
        if(b == 0) {
            return a;
        }

        while(b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }

        return a;
    }

}
