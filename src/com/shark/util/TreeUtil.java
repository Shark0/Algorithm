package com.shark.util;

public class TreeUtil {

    public static void main(String argv[]) {
        int[] input = {15, 9, 8, 1, 4, 11, 7, 12, 13, 6, 5, 3, 16, 02, 10, 14};
        TreeUtil printTree = new TreeUtil();
        printTree.print(input);
    }

    public static void print(int[] input) {
        int level = ((int) (Math.log(input.length) / Math.log(2))) + 1;
        for(int i = 0; i < level; i ++) {
            StringBuffer levelBuffer = new StringBuffer();
            int start = (int) Math.pow(2, i) - 1;
            int end = (int) Math.pow(2, i + 1) - 1;
            int outSpace = (int) (Math.pow(2, level - i - 1) - 1) * 2;
            for(int s = 0; s < outSpace; s ++) {
                levelBuffer.append("*");
            }
            for(int j = start; j < end; j++) {
                if(j < input.length) {
                    levelBuffer.append(String.format("%02d", input[j]));
                    if(j != end - 1) {
                        //level space node
                        int levelSpaceNodeWidth = (int) (Math.pow(2, level - i) - 1) * 2;
                        for(int s = 0; s < levelSpaceNodeWidth; s ++) {
                            if(j % 2 == 0) {
                                levelBuffer.append("*");
                            } else {
                                levelBuffer.append(" ");
                            }
                        }
                    }
                }
            }
            for(int s = 0; s < outSpace; s ++) {
                levelBuffer.append("*");
            }
            System.out.println(levelBuffer.toString());
        }
    }
}
