package com.leetcode.salesforce;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        final String input = "{[]}";
        final ValidParentheses obj = new ValidParentheses();
        System.out.println(obj.isValid(input));
        
    }

    public boolean isValid(String s) {
        boolean valid = true;
        final Stack<Character> stack1 = new Stack<Character>();

        final int len = s.length();
        for (int i = 0; i < len; i++) {
            final char ch = s.charAt(i);
            switch (ch) {
                case '(':
                    stack1.push(ch);
                    break;

                case ')':
                    if (stack1.size() > 0) {
                        final char tt = stack1.pop();
                        if (tt != '(') {
                            valid = false;
                            break;
                        }
                    } else {
                        valid = false;
                        break;
                    }
                    break;

                case '{':
                    stack1.push(ch);
                    break;

                case '}':
                    if (stack1.size() > 0) {
                        final char tt = stack1.pop();
                        if (tt != '{') {
                            valid = false;
                            break;
                        }
                    } else {
                        valid = false;
                        break;
                    }
                    break;

                case '[':
                    stack1.push(ch);
                    break;

                case ']':
                    if (stack1.size() > 0) {
                        final char tt = stack1.pop();
                        if (tt != '[') {
                            valid = false;
                            break;
                        }
                    } else {
                        valid = false;
                        break;
                    }
                    break;
            }
        }

        return valid && stack1.isEmpty();
    }
}
