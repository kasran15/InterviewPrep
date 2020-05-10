package com.kazz.interviews.utils;


public class Node {
    public Node left;
    public Node right;
    public int data;

    public Node(int data) {
        this.data = data;
    }
    
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    
    public boolean isLeaf() {
        return left == null && right == null;
    }
    
}