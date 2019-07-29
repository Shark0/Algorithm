package com.shark.search;

import com.shark.util.TreeUtil;

public class BinaryTreeSearch {


    public static void main(String argv[]) {
        int[] inputs = {15, 9, 8, 1, 4, 11, 7, 12, 13, 6, 5, 3, 16, 2, 10, 14};
//        int[] input = {15, 9, 8, 18, 16};
        BinaryTree binaryTree = null;
        for(int i: inputs) {
            if(binaryTree == null) {
                binaryTree = new BinaryTree(i);
            } else {
                binaryTree.add(i);
            }
        }
        System.out.println("height: " + binaryTree.root.getHeight());
        System.out.println("contains: " + binaryTree.contains(20));
        TreeUtil.print(binaryTree.root);

        System.out.println("start remove");
        for(int i: inputs) {
            binaryTree.remove(i);
            TreeUtil.print(binaryTree.root);
        }
    }

    public static class BinaryTree {
        BinaryNode root;
        public BinaryTree(int value) {
            root = new BinaryNode(value);
        }

        public void add(int value) {
            root = root.add(value);
        }

        public void remove(int value) {
            root = root.remove(value);
        }

        public boolean contains(int value) {
            BinaryNode node = root;
            while (node != null) {
                if(node.getValue() == value) {
                    return true;
                } else if (node.getValue() > value) {
                    node = node.getLeft();
                } else {
                    node = node.getRight();
                }
            }
            return false;
        }
    }
}
