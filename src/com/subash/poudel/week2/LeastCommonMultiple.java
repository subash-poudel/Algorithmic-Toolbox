package com.subash.poudel.week2;

public class LeastCommonMultiple {

    private LeastCommonMultiple(){}

    public static void testGetLCM() {
        String status = getLCM(6, 8) == 24 ? "success" : "fail";
        String status1 = getLCM( 28851538, 1183019) == 1933053046 ? "success" : "fail";
        System.out.println(status);
        System.out.println(status1);
    }



    //    Task. Given two integers a and b, find their least common multiple.
//    Sample 1.
//    Input: 6 8
//    Output: 24
//
//    Sample 2.
//    Input: 28851538 1183019
//    Output: 1933053046
    public static long getLCM(long a, long b) {
        // we are using the property hcf * lcm = a * b
        long hcf = GreatestCommonDivisor.getGCD(a, b);
        long product = a * b;
        long lcm = product / hcf;
        return lcm;
    }
}
