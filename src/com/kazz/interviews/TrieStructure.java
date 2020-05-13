package com.kazz.interviews;

import java.util.ArrayList;
import java.util.List;

public class TrieStructure {

    private TrieNode root;

    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnding = false;
    }

    public static void main(String[] args) {

        TrieStructure dict = new TrieStructure();

        dict.add("cow");
        dict.add("moo");
        dict.add("dog");
        dict.add("cat");

        System.out.println(dict.search("dog"));
        System.out.println(dict.search("doggo"));
        
        System.out.println(dict.words());

    }

    public void add(String s) {
        if (root == null) {
            root = new TrieNode();
        }

        char[] chars = s.toLowerCase().toCharArray();

        TrieNode node = root;

        for (char ch : chars) {
            int x = ch - 'a';
            if (node.children[x] == null) {
                node.children[x] = new TrieNode();
            }

            node = node.children[x];

        }

        node.isWordEnding = true;
    }

    public boolean search(String s) {
        char[] chars = s.toLowerCase().toCharArray();

        TrieNode node = root;

        for (char ch : chars) {
            int x = ch - 'a';
            if (node.children[x] == null) {
                return false;
            }

            node = node.children[x];

        }

        return node.isWordEnding;
    }
    
    public List<String> words() {
        return dfs(root, new StringBuilder(), new ArrayList<String>());
    }
    
    private List<String> dfs(TrieNode node, StringBuilder sb, List<String> results) {
        if (node == null) {
            return results;
        }
        
        System.out.println(sb);
        
        if (node.isWordEnding) {
            results.add(sb.toString());
        }
        
        for (int i = 0; i < node.children.length; i++) {
            StringBuilder sbChild = new StringBuilder(sb);
            sbChild.append((char) ('a' + i));
            dfs(node.children[i], sbChild, results);
        }
        
        return results;
    }

}
