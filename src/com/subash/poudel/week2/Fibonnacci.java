package com.subash.poudel.week2;


public class Fibonnacci {

    private Fibonnacci(){}

    public static void testGetFibonacciNumFor() {
        System.out.println(getFibonacciNumFor(10)); // 55
    }

    public static void testLastDigitOfFibonacciNum() {
        if(getLastDigitOf(3) == 2) {
            System.out.println("getLastDigitOf(3) success");
        } else {
            System.out.println("getLastDigitOf(3) failed");
        }
        if(getLastDigitOf(331) == 9) {
            System.out.println("getLastDigitOf(331) success");
        } else {
            System.out.println("getLastDigitOf(331) failed");
        }
        if(getLastDigitOf(327305) == 5) {
            System.out.println("getLastDigitOf(327305) success");
        } else {
            System.out.println("getLastDigitOf(327305) failed");
        }

    }


//    Problem Description
//    Task. Given an integer n, find the last digit of the nth Fibonacci number F n (that is, F n mod 10).
//    Input Format. The input consists of a single integer n.
//    Constraints. 0 ≤ n ≤ 10 7 .
//    Output Format. Output the last digit of F n .
//
//    Sample 1.
//    Input: 3
//    Output: 2
//
//    Sample 2.
//    Input: 331
//    Output: 9
//
//    Sample 3.
//    Input: 327305
//    Output: 5

    public static int getLastDigitOf(int n) {
        if(n <= 1) {
            return n;
        }
        int n1 = 0;
        int n2 = 1;
        for(int i = 2; i <= n; i++) {
            int temp = n2;
            n2 = (n1 + n2) % 10;
            n1 = temp;
        }
        return n2;
    }

    //    Problem Description
//        Task. Given an integer n, find the nth Fibonacci number F n .
//        Input Format. The input consists of a single integer n.
//        Constraints. 0 ≤ n ≤ 45.
//        Output Format. Output F n .
//        Sample 1.
//        Input: 10
//        Output: 55.

    public static long getFibonacciNumFor(int n) {
        if (n <= 1) {
            return n;
        }
        long n1 = 0;
        long n2 = 1;
        for(int i = 2; i <= n; i++) {
            long temp = n2;
            n2 = n1 + n2;
            n1 = temp;
        }
        return n2;
    }

}
