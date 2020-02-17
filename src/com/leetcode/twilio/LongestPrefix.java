package com.leetcode.twilio;

public class LongestPrefix {

    public static void main(String[] args) {
        final LongestPrefix obj = new LongestPrefix();
        final String[] strs = {"flower", "flow", "flight", "g"};
        System.out.println(obj.longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        final StringBuilder builder = new StringBuilder("");
        int i = 0;
        boolean app = true;
        if (strs.length > 0) {
            while (app && strs[0].length() > i) {
                final char ch = strs[0].charAt(i);
                for (int x = 1; x < strs.length; x++) {
                    if (strs[x].length() <= i || strs[x].charAt(i) != ch) {
                        app = false;
                        break;
                    }
                }
                if (app) {
                    builder.append(ch);
                }
                i++;
            }
        }
        return builder.toString();
    }
}
