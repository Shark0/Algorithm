package com.shark.search;

import com.shark.util.TreeUtil;

public class BinaryNode {

    private BinaryNode left;
    private BinaryNode right;
    private int value;
    private int height;

    public BinaryNode(int value) {
        this.value = value;
        this.height = 0;
    }

    public BinaryNode add(int value) {
        BinaryNode root = this;
        System.out.println("value: " + this.value + ", add: " + value);
        if (value < this.value) {
            this.left = addToSubTree(this.left, value);
//            System.out.println("heightDifference: " + heightDifference());
            if (heightDifference() == 2) {
               if(value <= this.left.value) {
                   System.out.println("before rotate right");
                   TreeUtil.print(root);
                   root = this.rotateRight();
                   System.out.println("after rotate right");
                   TreeUtil.print(root);
               } else {
                   System.out.println("before rotate left right");
                   TreeUtil.print(root);
                   root = this.rotateLeftRight();
                   System.out.println("after rotate left right");
                   TreeUtil.print(root);
               }
            }
        } else {
            this.right = addToSubTree(this.right, value);
//            System.out.println("heightDifference: " + heightDifference());
            if (heightDifference() == -2) {
                if(value > this.right.value) {
                    System.out.println("before rotate left");
                    TreeUtil.print(root);
                    root = this.rotateLeft();
                    System.out.println("after rotate left");
                    TreeUtil.print(root);
                } else {
                    System.out.println("before rotate right left");
                    TreeUtil.print(root);
                    root = this.rotateRightLeft();
                    System.out.println("after rotate right left");
                    TreeUtil.print(root);
                }
            }
        }
        root.computeHeight();
        return root;
    }

    private BinaryNode addToSubTree(BinaryNode parent, int value) {
        if(parent == null) {
            return new BinaryNode(value);
        }
        parent = parent.add(value);
        return parent;
    }

    public BinaryNode remove(int removeValue) {
        System.out.println("remove this.value: " + this.value + ", removeValue: " + removeValue);
        BinaryNode root = this;
        if(removeValue == this.value) {
            System.out.println("removeValue == this.value this.value: " + this.value + ", removeValue: " + removeValue  +
                    ", heightDifference: " + heightDifference());
            if(this.left == null) {
                return this.right;
            }
            BinaryNode leftMaxChild = this.left;
            while(leftMaxChild.right != null) {
                leftMaxChild = leftMaxChild.right;
            }
            int leftMaxChildValue = leftMaxChild.value;
            System.out.println("remove left: "+ this.left.value + ", leftMaxChildValue: " + leftMaxChildValue);
            this.left = removeFromParent(this.left, leftMaxChildValue);
            this.value = leftMaxChildValue;
            System.out.println("removeValue == this.value this.value: " + this.value + ", removeValue: " + removeValue  +
                    ", heightDifference: " + heightDifference());
            if(heightDifference() == -2) {
                TreeUtil.print(this);
                if(this.right.heightDifference() <= 0) {
                    System.out.println("before rotate left");
                    TreeUtil.print(root);
                    root = this.rotateLeft();
                    System.out.println("after rotate left");
                    TreeUtil.print(root);
                } else {
                    System.out.println("before rotate right left");
                    TreeUtil.print(root);
                    root = this.rotateRightLeft();
                    System.out.println("after rotate right left");
                    TreeUtil.print(root);
                }
            }
        } else if(removeValue < this.value) {
            System.out.println("removeValue < this.value this.value: " + this.value + ", removeValue: " + removeValue  +
                    ", heightDifference: " + this.heightDifference());
            this.left = removeFromParent(this.left, removeValue);
            System.out.println("removeValue == this.value this.value: " + this.value + ", removeValue: " + removeValue  +
                    ", heightDifference: " + heightDifference());
            if(this.heightDifference() == -2) {
                TreeUtil.print(root);
                if(this.right.heightDifference() <= 0) {
                    System.out.println("before rotate left");
                    TreeUtil.print(root);
                    root = rotateLeft();
                    System.out.println("after rotate left");
                    TreeUtil.print(root);
                } else {
                    System.out.println("before rotate right left");
                    TreeUtil.print(root);
                    root = rotateRightLeft();
                    System.out.println("after rotate right left");
                    TreeUtil.print(root);
                }
            }
        } else {
            System.out.println("removeValue > this.value this.value: " + this.value + ", removeValue: " + removeValue  +
                    ", heightDifference: " + this.heightDifference());
            this.right = removeFromParent(this.right, removeValue);
            System.out.println("removeValue == this.value this.value: " + this.value + ", removeValue: " + removeValue  +
                    ", heightDifference: " + heightDifference());
            if(this.heightDifference() == 2) {
                TreeUtil.print(root);
                if(this.left.heightDifference() >= 0) {
                    System.out.println("before rotate right");
                    TreeUtil.print(root);
                    root = rotateRight();
                    System.out.println("after rotate right");
                    TreeUtil.print(root);
                } else {
                    System.out.println("before rotate left right");
                    TreeUtil.print(root);
                    root = rotateLeftRight();
                    System.out.println("after rotate left right");
                    TreeUtil.print(root);
                }
            }
        }
        root.computeHeight();
        return root;
    }


    public BinaryNode removeFromParent(BinaryNode parent, int value) {
        if(parent != null) {
            return parent.remove(value);
        }
        return null;
    }

    public void computeHeight() {
//        System.out.println("computeHeight value: " + this.value);
        int height = -1;
        if (this.left != null) {
//            System.out.println("computeHeight left value: " + left.value + ", left height: " + left.height);
            height = Math.max(height, this.left.height);
        }
        if (this.right != null) {
//            System.out.println("computeHeight right value: " + right.value + ", right height: " + right.height);
            height = Math.max(height, this.right.height);
        }
        this.height = height + 1;
    }

    public int heightDifference() {
        int leftTarget = 0;
        int rightTarget = 0;
        if (this.left != null) {
            leftTarget = this.left.height + 1;
        }
        if (this.right != null) {
            rightTarget = this.right.height + 1;
        }
        return leftTarget - rightTarget;
    }

    public BinaryNode rotateRight() {
        BinaryNode root = this.left;
        BinaryNode leftRight = root.right;
        this.left = leftRight;
        root.right = this;

        this.computeHeight();
        root.computeHeight();;
        return root;
    }


    public BinaryNode rotateRightLeft() {
        BinaryNode right = this.right;
        BinaryNode root = right.left;
        BinaryNode rightLeftLeftGrandson = root.left;
        BinaryNode rightLeftRightGrandson = root.right;
        right.left = rightLeftRightGrandson;
        this.right = rightLeftLeftGrandson;
        root.left = this;
        root.right = right;
        right.computeHeight();
        this.computeHeight();
        root.computeHeight();
        return root;
    }

    public BinaryNode rotateLeft() {
        BinaryNode root = this.right;
        BinaryNode rightLeft = root.left;
        this.right = rightLeft;
        root.left = this;
        this.computeHeight();
        root.computeHeight();
        return root;
    }

    public BinaryNode rotateLeftRight() {
        BinaryNode left = this.left;
        BinaryNode root = left.right;
        BinaryNode leftRightLeftGrandson = root.left;
        BinaryNode leftRightRightGrandson = root.right;
        left.right = leftRightLeftGrandson;
        this.left = leftRightRightGrandson;
        root.left = left;
        root.right = this;
        left.computeHeight();
        this.computeHeight();
        root.computeHeight();
        return root;
    }


    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
