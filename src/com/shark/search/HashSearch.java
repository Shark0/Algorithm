package com.shark.search;

import java.util.Iterator;
import java.util.LinkedList;

public class HashSearch<V> {

    private final int tableSize = 1024;
    private LinkedList<V>[] table;

    public HashSearch(Iterator<V> input) {
        table = new LinkedList[tableSize];
        while (input.hasNext()) {
            V value = input.next();
            int hash = hash(value);
            if (table[hash] == null) {
                table[hash] = new LinkedList<>();
            }
            table[hash].add(value);
        }
    }

    public boolean search(V value) {
        int hash = hash(value);
        LinkedList list = table[hash];
        if(list == null) {
            return false;
        }
        return list.contains(value);
    }

    private int hash(V value) {
        int hashCode = value.hashCode();
        if(hashCode < 0) {
            hashCode = 0 - hashCode;
        }
        return hashCode % tableSize;
    }
}
