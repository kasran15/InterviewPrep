package com.kazz.interviews;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.kazz.interviews.utils.Node;

public class DiameterBinaryTree {
    
    public static void main(String[] args) {
        Node root = new Node(5);

        root.left = new Node(2);
        root.right = new Node(40);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.left = new Node(35);
        
        root.right.right = new Node(100);
        
        root.right.right.right = new Node(200);

        System.out.println(new DiameterBinaryTree().findDiameter(root).diameter);

    }
    
    public static class Meta {
        public int diameter;
        public int height;
        
        @Override
        public String toString() {
            return String.format("Diameter = %d, Height = %d", diameter, height);
        }
        
    }
    
    public Meta findDiameter(Node root) {
        
        if (root == null) {
            Meta m = new Meta();
            m.diameter = 0;
            m.height = 0;
            return m;
        }
        
        
        Meta left = findDiameter(root.left);
        Meta right = findDiameter(root.right);
        
        Meta m = new Meta();
        
        int height = Math.max(left.height, right.height) + 1;
        
        int diameter = Math.max(left.diameter, right.diameter);
        
        m.height = height;
        m.diameter = Math.max(diameter, left.height + right.height + 1);
        
        System.out.println(root.data + " " + m);
        
        return m;
    }

}
