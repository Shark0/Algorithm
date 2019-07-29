package com.shark.search;

public class BinarySearch<T extends Comparable<T>> {

    public boolean search(T[] collection, T target) {
        if (target == null) {
            return false;
        }
        int low = 0;
        int height = collection.length - 1;
        while (low <= height) {
            int mid = (low + height) / 2;
            int compareResult = target.compareTo(collection[mid]);
            if(compareResult < 0) {
                height = mid - 1;
            } else if (compareResult > 0) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
