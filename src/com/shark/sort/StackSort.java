package com.shark.sort;

import com.shark.util.SortUtil;
import com.shark.util.TreeUtil;

import java.util.Arrays;

public class StackSort {

    public static void main(String argv[]) {
        int[] input = {15, 9, 8, 1, 4, 11, 7, 12, 13, 6, 5, 3, 16, 02, 10, 14};
        TreeUtil.print(input);
        //先取得第一個最大的
        buildHeap(input);
        for(int i = input.length - 1; i >= 0; i --) {
            //把最大的逐步跟最後面的調換
            SortUtil.swap(input, 0, i);
            TreeUtil.print(input);
            heapify(input, 0, i);
        }
        System.out.println("result: " + Arrays.toString(input));
    }

    private static void buildHeap(int[] input) {
        for(int i = (input.length - 1) / 2 - 1; i >= 0; i --) {
            heapify(input, i, input.length);
        }
    }

    public static void heapify(int[] input, int index, int max) {
        //將最大節點的值變成父節點
        int largestIndex = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        System.out.println("heapify index: " + index + ", left: " + left + ", right: " + right);
        if(left < max && input[left] > input[index]) {
            largestIndex = left;
        }
        if(right < max && input[right] > input[largestIndex]) {
            largestIndex = right;
        }
        if(largestIndex != index) {
//            System.out.println("heapify index: " + index + ", index value: " + input[index] +
//                    ", left: " + left+ ", left value: " + input[left] + "right: " + right+ ", right value: " + input[right] +
//                    ", larget: " + largestIndex + ", largest value: " + input[largestIndex]);
            SortUtil.swap(input, index, largestIndex);
            TreeUtil.print(input);
            heapify(input, largestIndex, max);
        }
    }
}
