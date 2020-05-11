package com.kazz.interviews;

import org.apache.commons.lang3.StringUtils;

public class StringInterview {

    public static void main(java.lang.String[] args) {

        System.out.println(new StringInterview().almostPalindrome("abccba"));

    }

    public String almostPalindrome(String input) {

        if (StringUtils.isEmpty(input)) {
            return "";
        }

        int l = 0, r = input.length() - 1;

        while (l < r) {
            if (input.charAt(l) == input.charAt(r)) {
                l++;
                r--;
                continue;
            }

            int toRemove = l;

            if (input.charAt(l) == input.charAt(r - 1)) {
                toRemove = r;
            }

            StringBuilder sb = new StringBuilder(input);

            sb.deleteCharAt(toRemove);
            return sb.toString();

        }

        return input;
    }

}
