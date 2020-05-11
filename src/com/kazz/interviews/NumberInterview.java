package com.kazz.interviews;

public class NumberInterview {

    public static void main(String[] args) {
        System.out.println(new NumberInterview().binaryAdd("1101", "100"));
    }

    public String binaryAdd(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        boolean carry = false;
        while (i < num1.length() || i < num2.length()) {

            char c1 = i < num1.length() ? num1.charAt(num1.length() - i - 1) : '0';
            char c2 = i < num2.length() ? num2.charAt(num2.length() - i - 1) : '0';

            char x;

            if (c1 == '1' && c2 == '1') {

                if (carry) {
                    carry = true;
                    x = '1';
                } else {
                    x = '0';
                    carry = true;
                }

            } else if (c1 == '0' && c2 == '0') {
                if (carry) {
                    x = '1';
                    carry = false;
                } else {
                    x = '0';
                }
            } else {
                if (carry) {
                    x = '0';
                } else {
                    x = '1';

                }
            }
            
            sb.insert(0, x);
            i++;
            
            System.out.println(c1 + ", " + c2 + " = " + x + " " + carry);

        }
        
        if (carry) {
            sb.insert(0, '1');
        }

        return sb.toString();
    }
}
