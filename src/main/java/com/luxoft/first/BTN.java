/*
We have a class representing binary tree nodes: class BTN { int val; BTN left; BTN right; }
please implement Java method to compare 2 such trees (returns: true if fully equal, false - otherwise)
* */
package com.luxoft.first;

public class BTN {

    private int val;
    private BTN left;
    private BTN right;

    public BTN(int val, BTN left, BTN right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(BTN left) {
        this.left = left;
    }

    public void setRight(BTN right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public BTN getLeft() {
        return left;
    }

    public BTN getRight() {
        return right;
    }

    // tested by unit test BTNTest
    public static boolean compare(BTN first, BTN second) {
        if (first == second) {
            return true;
        }

        if (first == null || second == null) {
            return false;
        }

        boolean isLeftTheSame = compare(first.getLeft(), second.getLeft());
        boolean isRightTheSame = compare(first.getRight(), second.getRight());

        return first.getVal() == second.getVal() && isLeftTheSame && isRightTheSame;
    }
}
