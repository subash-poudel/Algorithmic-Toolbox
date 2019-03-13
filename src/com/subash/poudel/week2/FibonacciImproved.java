package com.subash.poudel.week2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

public class FibonacciImproved {

    private FibonacciImproved(){}

    public static void test() {
        testGetFibonacci();
    }

    public static void testGetFibonacci() {
//        String status = getFibonacci(10) == 55 ? "success": "fail"; // 55
//        String status1 = getFibonacci(239) == 39679027332006820581608740953902289877834488152161L ? "success": "fail"; // 55
//        System.out.println(status);
//        System.out.println(status1);
        BigInteger fib = getFibonacci(239);
        System.out.println(fib);

//        System.out.println( getFibonacci(0));
//        System.out.println( getFibonacci(1));
//        System.out.println( getFibonacci(2));
//        System.out.println( getFibonacci(3));
//        System.out.println( getFibonacci(4));
//        System.out.println( getFibonacci(5));
//        System.out.println( getFibonacci(6));
//        System.out.println( getFibonacci(7));
//        System.out.println( getFibonacci(8));
//        System.out.println( getFibonacci(9));
//        System.out.println( getFibonacci(10));
//        System.out.println( getFibonacci(11));
//        System.out.println( getFibonacci(12));
//        System.out.println( getFibonacci(13));
    }

    public static void testGetFibonacciModulus() {
        String status = getFibonacciModulus(239, 1000) == 161 ? "success": "fail"; // 55
        System.out.println(status);
        String status1 = getFibonacciModulus(281621 ,239)  == 151 ? "success": "fail"; // 55
        System.out.println(status1);

    }

    //    Problem Description
//    Task. Given two integers n and m, output F n mod m (that is, the remainder of F n when divided by m).
//
//    Sample 1.
//    Input: 239 1000
//    Output: 161
//
//    Sample 2.
//    Input: 2816213588 239
//    Output: 151
    public static long getFibonacciModulus(int n, int mod) {
        BigInteger fib = getFibonacci(n);
        BigInteger bigMod = fib.mod(BigInteger.valueOf(mod));
        return bigMod.longValue();
    }

    // solution based on http://www.maths.surrey.ac.uk/hosted-sites/R.Knott/Fibonacci/fibFormula.html#section1
    // the solution below fails for very big numbers cannot find a reason why
    public static BigInteger getFibonacci(int n) {
        if(n <=1) {
            return BigInteger.valueOf(n);
        }
        RoundingMode mode = RoundingMode.UNNECESSARY;
        MathContext context = MathContext.DECIMAL128;
        BigDecimal rootFive = new BigDecimal(5).sqrt(context);

        BigDecimal phiPlus = rootFive.add(BigDecimal.ONE).divide(new BigDecimal(2), mode);
        BigDecimal phiMinus = BigDecimal.ONE.subtract(rootFive).divide(new BigDecimal(2), mode);

        BigDecimal decimal1 = phiPlus.pow(n);
        BigDecimal decimal2 = phiMinus.pow(n);
        BigDecimal bigDecimal = decimal1.subtract(decimal2).divide(rootFive, mode);
        bigDecimal = bigDecimal.round(context);

        // 3967902733200682058160874095390 2289877834488152161
        // 3967902733200682058160874095390 1600000000000000000
        return bigDecimal.toBigInteger();
    }
}
