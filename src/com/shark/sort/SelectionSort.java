package com.shark.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String argv[]) {
        int[] input = {15, 9, 8, 1, 4, 11, 7, 12, 13, 6, 5, 3, 16, 02, 10, 14};
        sort(input);
    }

    private static void sort(int[] input) {
        for(int i = input.length -1; i >= 0; i --) {
            //取出最大的擺最右邊
            int max = -1;
            int maxIndex = -1;
            for(int j = 0; j <= i; j ++) {
                if(input[j] > max) {
                    max = input[j];
                    maxIndex = j;
                }
            }
            input[maxIndex] = input[i];
            input[i] = max;
            System.out.println("process i: " + i + ", result: " + Arrays.toString(input));
            System.out.println("process maxIndex: " + maxIndex + ", max: " + max);
        }
    }


}
