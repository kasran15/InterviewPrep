package com.kazz.interviews;

import java.util.Stack;

public class ParanthesisInterview {

    public static void main(String[] args) {

        System.out.println(new ParanthesisInterview().longestValidParentheses("(()"));

    }

    public int longestValidParentheses(String s) {

        if (s == null || s.length() <= 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int max = 0;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '(') {

                stack.push(i);

            } else if (chars[i] == ')') {

                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int index = stack.peek();

                    if (i - index > max) {
                        max = i - index;
                    }

                }
            }
            System.out.println(stack);
        }

        return max;

    }

}
