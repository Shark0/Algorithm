package com.shark.graph;

import java.util.Arrays;

public class ShortestPath {

    private int searchMinDistanceIndex(int distanceArray[], boolean shortPathTreeSet[]) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        System.out.print("searchMinDistanceIndex distanceArray: ");
        for(int i = 0; i < distanceArray.length; i ++) {
            if(distanceArray[i] != Integer.MAX_VALUE && !shortPathTreeSet[i]) {
                System.out.print(i + ": " + distanceArray[i] + "(" + shortPathTreeSet[i] + ") ");
            }
            if(i == (distanceArray.length - 1)) {
                System.out.println("");
            }
        }
        for (int i = 0; i < shortPathTreeSet.length; i ++) {
            if (!shortPathTreeSet[i]&& distanceArray[i] < min) {
                min = distanceArray[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void dijkstra(int[][] graph, int start) {
        int distanceArray[] = new int[graph.length];
        boolean shortPathTreeSet[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i ++) {
            distanceArray[i] = Integer.MAX_VALUE;
            shortPathTreeSet[i] = false;
        }
        distanceArray[start] = 0;
        for(int i = 0; i < graph.length; i++) {
            System.out.println("====================================================");
            int minDistanceIndex = searchMinDistanceIndex(distanceArray, shortPathTreeSet);
            shortPathTreeSet[minDistanceIndex] = true;
            System.out.println("i: " + i + ", minDistanceIndex: " + minDistanceIndex);
            System.out.println("minDistanceIndex: " + minDistanceIndex);
            System.out.println("graph[minDistanceIndex][]: " + Arrays.toString(graph[minDistanceIndex]));
            for (int j = 0; j < graph.length; j++) {
                if (!shortPathTreeSet[j] &&
                        graph[minDistanceIndex][j] != 0 &&
                        distanceArray[minDistanceIndex] != Integer.MAX_VALUE &&
                        distanceArray[minDistanceIndex]+ graph[minDistanceIndex][j] < distanceArray[j]) {
                    System.out.println("j: " + j +
                            ", minDistanceIndex: " + minDistanceIndex +
                            ", distanceArray[minDistanceIndex]:" + distanceArray[minDistanceIndex] +
                            " + graph[minDistanceIndex][j]: " + graph[minDistanceIndex][j] +
                            " = " + (distanceArray[minDistanceIndex] + graph[minDistanceIndex][j]) +
                            " < distanceArray[j]: " + distanceArray[j]);

                    distanceArray[j] = distanceArray[minDistanceIndex] + graph[minDistanceIndex][j];
                }
            }
            System.out.println("i: " + i +", distanceArray: " + Arrays.toString(distanceArray));
        }
    }

    public  void bellmanFord(int[][] graph, int start) {
        int distanceArray[] = new int[graph.length];
        boolean shortPathTreeSet[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i ++) {
            distanceArray[i] = Integer.MAX_VALUE;
            shortPathTreeSet[i] = false;
        }
        distanceArray[start] = 0;
        int minDistanceIndex = searchMinDistanceIndex(distanceArray, shortPathTreeSet);
        while(minDistanceIndex != -1) {
            shortPathTreeSet[minDistanceIndex] = true;
            System.out.println("minDistanceIndex: " + minDistanceIndex);
            System.out.println("graph[" + minDistanceIndex + "][]: " + Arrays.toString(graph[minDistanceIndex]));
            System.out.println("shortPathTreeSet[]: " + Arrays.toString(shortPathTreeSet));
            for (int j = 0; j < graph[minDistanceIndex].length; j++) {
                if((graph[minDistanceIndex][j] != 0 && distanceArray[minDistanceIndex] != Integer.MAX_VALUE) &&
                        (distanceArray[minDistanceIndex]+ graph[minDistanceIndex][j] < distanceArray[j])) {

                    System.out.println("j: " + j +
                            ", minDistanceIndex: " + minDistanceIndex +
                            ", distanceArray[minDistanceIndex]: " + distanceArray[minDistanceIndex] +
                            " + graph[minDistanceIndex][j]: " + graph[minDistanceIndex][j] +
                            " = " + (distanceArray[minDistanceIndex] + graph[minDistanceIndex][j]) +
                            " < distanceArray[j]: " + distanceArray[j]);

                    distanceArray[j] = distanceArray[minDistanceIndex] + graph[minDistanceIndex][j];
                    shortPathTreeSet[j] = false;
                }
            }
            System.out.println("distanceArray: " + Arrays.toString(distanceArray));
            minDistanceIndex = searchMinDistanceIndex(distanceArray, shortPathTreeSet);
        }
    }

    public static void main(String argv[]) {
        ShortestPath shortestPath = new ShortestPath();
//        int graph[][] = new int[][] {
//                {0, 4, 0, 0, 0, 0, 0, 8, 0},
//                {4, 0, 8, 0, 0, 0, 0, 11, 0},
//                {0, 8, 0, 7, 0, 4, 0, 0, 2},
//                {0, 0, 7, 0, 9, 14, 0, 0, 0},
//                {0, 0, 0, 9, 0, 10, 0, 0, 0},
//                {0, 0, 4, 14, 10, 0, 2, 0, 0},
//                {0, 0, 0, 0, 0, 2, 0, 1, 6},
//                {8, 11, 0, 0, 0, 0, 1, 0, 7},
//                {0, 0, 2, 0, 0, 0, 6, 7, 0}
//        };
//        shortestPath.dijkstra(graph, 1);

        int graph[][] = new int[][] {
                {0, 0, 0, 0, 2},
                {0, 0, 0, -2, 0},
                {0, -3, 0, 0, 0},
                {0, 0, 6, 0, 0},
                {0, 5, 0, 4, 0},
        };
        shortestPath.bellmanFord(graph, 0);
    }

}
