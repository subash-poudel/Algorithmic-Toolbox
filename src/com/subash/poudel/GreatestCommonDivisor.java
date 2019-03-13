package com.subash.poudel;

public class GreatestCommonDivisor {

    private GreatestCommonDivisor(){}

    public static int getGCD(int a, int b) {
        return euclidGCD(a, b);
    }

    private static int euclidGCD(int a, int b) {
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
