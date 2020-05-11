package com.kazz.interviews;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import org.apache.commons.lang3.tuple.Pair;

public class MergeKSorted {

    public static void main(String[] args) {

        List<Integer> l1 = List.of(2, 6, 8);
        List<Integer> l2 = List.of(3, 6, 7);
        List<Integer> l3 = List.of(1, 3, 4);

        List<List<Integer>> input = List.of(l1, l2, l3);
        
        System.out.println(new MergeKSorted().sort(input));

    }

    public List<Integer> sort(List<List<Integer>> sortedLists) {

        Queue<Pair<Integer, Integer>> q = new PriorityQueue<>();

        List<Integer> pointers = new ArrayList<>();

        for (int k = 0; k < sortedLists.size(); k++) {
            pointers.add(0);
        }

        int index = 0;

        // initialize
        for (List<Integer> list : sortedLists) {
            q.add(Pair.of(list.get(0), index++));
        }

        List<Integer> merge = new ArrayList<Integer>();

        while (!q.isEmpty()) {

            Pair<Integer, Integer> min = q.poll();
            
            System.out.println(pointers);
            System.out.println(min);
            
            merge.add(min.getLeft());

            List<Integer> k = sortedLists.get(min.getRight());

            int kIndex = pointers.get(min.getRight()) + 1;
            
            pointers.set(min.getRight(), kIndex);

            if (kIndex < k.size()) {
                q.add(Pair.of(k.get(kIndex), min.getRight()));
            }

        }

        return merge;
    }

}
