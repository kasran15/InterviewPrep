package com.kazz.interviews;

import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.add(5);
        q.add(50);
        q.add(15);
        q.add(1);

        q.forEach(System.out::println);

    }

}
