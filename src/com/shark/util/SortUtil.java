package com.shark.util;

public class SortUtil {

    public static void swap(int[] input, int a, int b) {
        System.out.println("swap a: " + a + ", b: " + b);
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
