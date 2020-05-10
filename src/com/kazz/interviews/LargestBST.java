package com.kazz.interviews;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.kazz.interviews.utils.Node;

/**
 * Given a Binary Tree, find the size of the largest binary search tree (BST).
 * @author kazz
 *
 */
public class LargestBST {

    public static void main(String[] args) {
        Node root = new Node(5);

        root.left = new Node(2);
        root.right = new Node(40);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(35);
        
        root.right.right = new Node(100);

        System.out.println(new LargestBST().maxSize(root).ans);

    }

    public boolean isBST(Node node) {
        if (node == null) {
            return true;
        }

        if ((node.left != null && node.left.data > node.data) || (node.right != null && node.right.data < node.data)) {
            return false;
        }

        return isBST(node.left) && isBST(node.right);
    }

    public Meta maxSize(Node node) {

        if (node == null) {
            return null;
        }

        Meta meta1 = maxSize(node.left);
        Meta meta2 = maxSize(node.right);

        Meta meta = new Meta();
        meta.size = (meta1 == null ? 0 : meta1.size) + (meta2 == null ? 0 : meta2.size) + 1;

        meta.ans = Math.max((meta1 == null ? 0 : meta1.ans), (meta2 == null ? 0 : meta2.ans));

        if ((meta1 == null || meta1.isBST) && (meta2 == null || meta2.isBST)) {
            if ((meta2 == null || node.data < meta2.min) && (meta1 == null || node.data >= meta1.max)) {
                meta.isBST = true;

                meta.ans = meta.size;
                meta.min = meta1 == null ? node.data : meta1.min;
                meta.max = meta2 == null ? node.data : meta2.max;
            }
        }

        return meta;
    }

    public static class Meta {
        public int size = 0;
        public int max = Integer.MIN_VALUE;
        public int min = Integer.MAX_VALUE;
        public boolean isBST = false;

        public int ans = 0;

        public String toString() {
            return ReflectionToStringBuilder.toString(this);
        }

    }

}
