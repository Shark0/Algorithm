package com.shark.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class BucketSort {

    public static void main(String[] argv) {
        int[] input = {15, 9, 8, 1, 4, 11, 7, 12, 13, 6, 5, 3, 16, 02, 10, 14};
        sort(input);
        System.out.println("input: " + Arrays.toString(input));
    }

    private static void sort(int[] input) {
        HashMap<Integer, ArrayList<Integer>> bucket = new HashMap();
        for(int i = 0; i < input.length; i ++) {
            int value = input[i];
            int hash = value / 3;
            ArrayList<Integer> sortList = bucket.get(hash);
            if(sortList == null) {
                sortList = new ArrayList<>();
                bucket.put(hash, sortList);
            }
            sortList.add(value);
        }
        int i = 0;
        for(Integer hash: bucket.keySet()) {
            ArrayList<Integer> sortList = bucket.get(hash);
            Collections.sort(sortList); //好像有些偷懶，也可以改成Array用Insert Sort
            for(Integer value: sortList) {
                input[i] = value;
                i ++;
            }
        }
    }
}
