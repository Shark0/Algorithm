package com.shark.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
	    int[] input = {15, 9, 8, 1, 4, 11, 7, 12, 13, 6, 5, 3, 16, 02, 10, 14};
	    sort(input);
    }

    private static void sort(int[] input) {
        for(int i = 0; i < input.length; i ++) {
            int value = input[i];
            int insertIndex = i -1;
            //將大於value的全部往右移
            while (insertIndex >= 0 && input[insertIndex] > value) {
                input[insertIndex + 1] = input[insertIndex];
                insertIndex = insertIndex - 1;
            }
            //將value插入適當位址
            input[insertIndex + 1] = value;
            System.out.println("process i: " + i + ", result: " + Arrays.toString(input));
        }
    }
}
