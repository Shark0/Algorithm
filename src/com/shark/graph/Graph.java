package com.shark.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjacencyArray[];

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyArray = new LinkedList[this.vertices];
        for (int i = 0; i < vertices; i++) {
            this.adjacencyArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        this.adjacencyArray[src].add(dest);
        this.adjacencyArray[dest].add(src);
    }

    public void print() {
        for (int i = 0; i < this.vertices; i++) {
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for (Integer pCrawl : this.adjacencyArray[i]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public void breadthFirstSearch(int start) {
        boolean visited[] = new boolean[this.vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (queue.size() != 0) {
            start = queue.poll();
            System.out.println(start + " ");
            Iterator<Integer> iterator = this.adjacencyArray[start].listIterator();
            while (iterator.hasNext()) {
                int n = iterator.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public void depthFirstSearch(int start) {
        boolean visited[] = new boolean[this.vertices];
        depthFirstSearch(start, visited);
    }

    private void depthFirstSearch(int start, boolean visited[]) {
        visited[start] = true;
        System.out.print(start + " ");
        Iterator<Integer> i = this.adjacencyArray[start].listIterator();
        while (i.hasNext()) {
            int next = i.next();
            if (!visited[next])
                depthFirstSearch(next, visited);
        }
    }

    public int getVertices() {
        return vertices;
    }

    public LinkedList<Integer>[] getAdjacencyArray() {
        return adjacencyArray;
    }
}
