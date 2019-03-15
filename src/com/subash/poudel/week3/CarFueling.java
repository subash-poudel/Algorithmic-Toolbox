package com.subash.poudel.week3;

public class CarFueling {

    public static void test() {
        int [] stops1 = {200, 375, 550, 750};
        int [] stops2 = {1, 2, 5, 9};
        int [] stops3 = {100, 150};
//        int refill1 = computeMinRefills(950, 400, stops1);
//        int refill2 = computeMinRefills(10, 3, stops2);
        int refill3 = computeMinRefills(200, 250, stops3);
//        System.out.println(refill1);
//        System.out.println(refill2);
        System.out.println(refill3);
    }

//    Input:  950
//            400
//            200 375 550 750
//    Output: 2
//
//    Input:
//            10
//            3
//            1 2 5 9
//    Output:
//            -1
    static int computeMinRefills(int dist, int tank, int[] stops) {

        for (int i = 1; i < stops.length; i++) {
            if ((stops[i] - stops[i -1] ) > tank) {
                return -1;
            }
        }
        int currentStop = 0;
        int index = 0;
        int remainingMileage = dist;
        while (index < stops.length) {
            int stop = index;
            while (stop < stops.length) {
                int distance = stops[stop];
                if (distance < remainingMileage) {
                    remainingMileage = remainingMileage - distance;
                    stop++;
                    index = stop;
                } else {
                    // need to stop here for refill
                    currentStop++;
                    break;
                }
            }
            index++;
        }

        return currentStop;
    }


}