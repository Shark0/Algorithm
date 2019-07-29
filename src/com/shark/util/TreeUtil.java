package com.shark.util;

import com.shark.search.BinaryNode;
import java.util.*;

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

    public static void print(BinaryNode root) {
        List<List<String>> lines = new ArrayList();
        List<BinaryNode> level = new ArrayList();
        List<BinaryNode> next = new ArrayList();
        level.add(root);

        int nodeNumber = 1;
        int widest = 0;
        while (nodeNumber != 0) {
            List<String> valueList = new ArrayList();
            nodeNumber = 0;
            for (BinaryNode node : level) {
                if (node == null) {
                    valueList.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String value = String.valueOf(node.getValue());
                    valueList.add(value);
                    if (value.length() > widest) {
                        widest = value.length();
                    }
                    next.add(node.getLeft());
                    next.add(node.getRight());

                    if (node.getLeft() != null) {
                        nodeNumber++;
                    }
                    if (node.getRight() != null) {
                        nodeNumber++;
                    }
                }
            }

            if (widest % 2 == 1) {
                widest++;
            }
            lines.add(valueList);
            List<BinaryNode> temp = level;
            level = next;
            next = temp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;
            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "─");
                        }
                        System.out.print(j % 2 == 0 ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }
            // print line of numbers
            for (int j = 0; j < line.size(); j++) {
                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            perpiece /= 2;
        }
    }}
