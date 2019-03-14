package com.subash.poudel.week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {


    public static void test() {
        int[] v1 = {60,100, 120};
        int[] w1 = {20,50 ,30};
        int[] v2 = {500 };
        int[] w2 = {30};
        double optimalVal1 = getOptimalValue(50, v1, w1);
        double optimalVal2 = getOptimalValue(10, v2, w2);
        System.out.println(optimalVal1);
        System.out.println(optimalVal2);
    }

    
    public static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        //write your code here
        List<Item> items = new ArrayList<>(values.length);
        for(int i = 0; i < values.length; i++) {
            items.add(new Item(values[i], weights[i]));
        }
        Collections.sort(items, new RateSort());

        int remainingCapacity = capacity;

        for (Item item: items) {
            int weight = item.getWeight();
            if(remainingCapacity >= weight) {
                value += item.getPrice();
                remainingCapacity = remainingCapacity - weight;
            } else {
                value += item.getRate() * remainingCapacity;
            }
        }
        return value;
    }

    private static class Item {
        private int price;
        private int weight;
        private float rate;

        public Item(int price, int weight) {
            this.price = price;
            this.weight = weight;
            this.rate = ((float) price) / weight;
        }

        public int getPrice() {
            return price;
        }

        public int getWeight() {
            return weight;
        }

        public float getRate() {
            return rate;
        }
    }

    private static class RateSort implements Comparator<Item> {
        @Override
        public int compare(Item item, Item t1) {
            // -1 to reverse the sorting order
            return Float.compare(item.getRate(), t1.getRate()) * -1;
        }
    }
}
