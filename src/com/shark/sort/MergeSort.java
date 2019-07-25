package com.shark.sort;

import com.shark.util.SortUtil;

import java.util.Arrays;

public class MergeSort {

    public static void main(String argv[]) {
        int[] input = {15, 9, 8, 1, 4, 11, 7, 12, 13, 6, 5, 3, 16, 02, 10, 14};
        mergeSort(input, 0, input.length);
        System.out.println("input: " + Arrays.toString(input));
    }

    private static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }
        if(end - start == 2) {
            if(input[start] > input[start + 1]) {
                SortUtil.swap(input, start, start + 1);
            }
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
//        System.out.println("input: " + Arrays.toString(input));
    }

    public static void merge(int[] input, int start, int mid, int end) {
        //o(n)
        System.out.println("merge start: " + start + ", mid: " + mid + ", end: " + end);
        System.out.println("merge input before: " + Arrays.toString(input));
        System.out.println("====================================");
        int i = start;
        int j = mid;
        int index = start;
        int[] temp = input.clone();
        while (index < end) {
            if(j >= end || (i < mid && temp[i] < temp[j])) {
                //右邊超過終點或左邊比右邊小
                System.out.println("merge i: " + i + ", i value: " + temp[i]);
                if(j < end) {
                    System.out.println("merge j: " + j + ", j value: " + temp[j]);
                }
                input[index] = temp[i];
                System.out.println("merge temp: " + Arrays.toString(temp));
                System.out.println("merge input: " + Arrays.toString(input));
                System.out.println("====================================");
                i = i + 1;
            } else {
                //左邊超過中間或右邊比左邊小
                System.out.println("merge j: " + j + ", j value: " + temp[j]);
                if(i < mid) {
                    System.out.println("merge i: " + i + ", i value: " + temp[i]);
                }
                input[index] = temp[j];
                System.out.println("merge temp: " + Arrays.toString(temp));
                System.out.println("merge input: " + Arrays.toString(input));
                System.out.println("====================================");
                j = j + 1;
            }
            index = index + 1;
        }
        System.out.println("merge input end: " + Arrays.toString(input));
        System.out.println("**************************************");
    }
}
