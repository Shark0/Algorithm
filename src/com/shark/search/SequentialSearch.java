package com.shark.search;

import java.util.Iterator;

public class SequentialSearch<T> {
    public boolean search(T[] collection, T target) {
        for(T item: collection) {
            if(item.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public boolean search(Iterable<T> collection, T target) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equals(target)) {
                return true;
            }
        }
        return false;
    }
}
