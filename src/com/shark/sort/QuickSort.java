package com.shark.sort;

import com.shark.util.SortUtil;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] argv) {
        int[] input = {15, 9, 8, 1, 4, 11, 7, 12, 13, 6, 5, 3, 16, 02, 10, 14};
        System.out.println(Arrays.toString(input));
        quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }

    private static void quickSort(int[] input, int left, int right) {
        if(right <= left) {
            return;
        }
        int pivotIndex = (left + right) / 2;
        int pivot = input[pivotIndex];
        System.out.println("left: " + left + ", right: " + right + ", pivotIndex: " + pivotIndex + ", pivot: " + pivot);
        System.out.println("start swap");
        SortUtil.swap(input, pivotIndex, right);
        System.out.println(Arrays.toString(input));
        int swapIndex = left;
        for(int i = left; i < right; i ++) {
            System.out.println("i: " + i + ", input[i]: " + input[i] + ", pivot: " + pivot);
            if(input[i] <= pivot) {
                SortUtil.swap(input, i, swapIndex);
                System.out.println(Arrays.toString(input));
                swapIndex = swapIndex + 1;
            }
        }
        System.out.println("end swap");
        System.out.println("swapIndex: " + swapIndex);
        SortUtil.swap(input, swapIndex, right);
        System.out.println(Arrays.toString(input));

        quickSort(input, left, swapIndex -1);
        quickSort(input, swapIndex + 1, right);

    }
}
