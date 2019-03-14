package com.subash.poudel.week3;

public class Change {

    private Change() {}

    public static void test() {
        String status = getChange(99) == 14 ? "Pass" : "Fail";
        String status1 = getChange(28) == 6 ? "Pass" : "Fail";
        System.out.println(status);
        System.out.println(status1);
    }


//    Task. The goal in this problem is to find the minimum number of coins needed to change the input value
//            (an integer) into coins with denominations 1, 5, and 10.
//
//    Input: 2
//    Output: 2
//
//    Input: 28
//    Output: 6
    public static int getChange(int m) {
        if(m < 0) {
            // can throw a runtime exception
            return -1;
        }
        if(m == 0) {
            return m;
        }
        // should always be in ascending order
        int[] denominations = {10, 5, 1};
        int coins = 0;
        for(int denomination: denominations) {
            coins += m / denomination;
            m = m % denomination;
            if(m == 0) {
                return coins;
            }
        }
        return coins;
    }
}

