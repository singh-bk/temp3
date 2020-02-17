package com.abkhilakh.www;

import java.util.Stack;

public class LongestValidParenthesis {

    public static void main(String[] args) {
        final LongestValidParenthesis obj = new LongestValidParenthesis();
        System.out.println(obj.longestValidParentheses("((())))(())"));
        //System.out.println(obj.longestValidParentheses("()()()(()))()()())))((()()()(()()))(()()()((()()))())(((())()())(()(()(()(())(((()())()))(()))()))))()())(()))))()()(())()()((())()()))))((()))))(()()((()(()(()())((())()()()()))()()()(())()()())((((()(())())))(((()(((()((((())())(()()()()(((((()))()(()(())))(((()()()()(()(((())(()(()()(()(()(())()))))))()))()())((()((((()(())(()()()(((((()())()))))())))((((()()()(()(())(((())(((()()((()((()(((()(()))(((())(((()((((()(())(((()((()(()())))))(()(()()(())))))()(()()((()))()))())())((())))()(())((((()((()))))()())()))((()(()())()())()()((()))())(()(()(())((((((()()((((())))())(((()()())))()(((()(()()((((())))))()()((((()(()()())(()(())()()()((()(()((((())))((((((())(()())()))))(()(()))()))))))(()()((()()()())(())))(((()))(()()()(()))((())()()()())()()(((())(()(())()()(()())((()()(((((())(()((((()(()()()(()))(()((((())()())()())())))())(((()(()((())()()((((()()()()))))))())())()(((((()())()(()()()()()(((())((((((()))(())()(()())(()(()())(()(())))())))(()()(()((((()()(())(()))()))(()))(()())())()))))))()()(())))))()))()(()())))((())(()()))()((()))()(())()()((((())()))((()(()))()(((()())()(()()((()())((((())()))))()(())())())())(((()(()())))((()))))()())))))(()((())))()())((()))()()))(())())()))()()((()(((())()()()((()()(()(())(()))())())(((()())(()())(()((()()()())()(()(((((((()()(((()(((((((())(()))))())()))))))))()(()(()((((())(()()(((()))()(())(((((((((()(()())())()(((()((()(((()(()()(()))(())))))))((("));
    }

    public int longestValid(String s) {
        final int len = s.length();
        final char[] ch = s.toCharArray();
        final int op = 0;
        int currentLen = len;

        while (currentLen > 0) {
            int startIndex = 0;

            while (startIndex + currentLen <= len) {
                boolean valid = true;
                final Stack<String> stack = new Stack<String>();
                for (int kk = startIndex; kk < startIndex + currentLen; kk++) {
                    if (ch[kk] == '(') {
                        stack.push("(");
                    } else {
                        if (!stack.isEmpty()) {
                            stack.pop();
                        } else {
                            valid = false;
                            break;
                        }
                    }
                }
                if (stack.isEmpty() && valid) {
                    return currentLen;
                }
                startIndex++;
            }
            currentLen--;
        }
        return op;
    }


    public int longestValidParentheses(String s) {
        int maxans = 0;
        final Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int longestValidInSinglePass(String str) {
        int max = 0;
        final int current = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        final char[] ch = str.toCharArray();
        final int len = ch.length;
        Stack<String> stack = new Stack<String>();
        int start = 0;
        int end = 0;
        while (start < len - 1 && end < len - 1) {
            start = end;
            while (ch[start] == ')') {
                start++;
                end = start;
            }

            if (start < len - 1 && end < len - 1) {
                stack.push(ch[start] + "");
                end = start + 1;
                boolean valid = true;
                while (valid && end < len - 1) {
                    if (ch[end] == '(') {
                        stack.push("(" + "");
                    } else {
                        if (stack.isEmpty()) {
                            valid = false;
                        } else {
                            stack.pop();
                        }
                    }
                    end++;
                }
                if (stack.isEmpty() && end - start > max) {
                    max = end - start;
                } else {
                    stack = new Stack<String>();
                }
            }
        }

        return max;

    }

    public int longestValid2(String str) {
        int max = 0;
        int current = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        final char[] ch = str.toCharArray();
        final int len = ch.length;
        final Stack<String> stack = new Stack<String>();
        int i = 0;
        while (ch[i] == ')')
            i++;
        if (i == len) {
            return 0;
        }
        stack.push(ch[i] + "");
        current = 1;
        max = 1;

        // for()



        for (int kk = i + 1; kk < len; kk++) {
            if (kk == ')' && !stack.isEmpty()) {
                stack.pop();
                current++;
                if (current > max) {
                    max = current;
                }
            }
            if (kk == '(') {
                stack.push("(");
            }
        }
        return max;
    }
}
