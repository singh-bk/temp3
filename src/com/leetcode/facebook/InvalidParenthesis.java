package com.leetcode.facebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InvalidParenthesis {

    public static void main(String[] args) {
        final String input = ")(";
        final InvalidParenthesis obj = new InvalidParenthesis();

        System.out.println(obj.removeInvalidParentheses(input));
    }

    public List<String> removeInvalidParentheses(String s) {
        List<String> op = new LinkedList<String>();
        final int len = s.length();
        final Stack<Integer> stack1 = new Stack<Integer>();
        final Stack<Integer> stack2 = new Stack<Integer>();
        int count1 = 0;
        int count2 = 0;
        final boolean modified = false;
        int deletedCount = 0;
        for (int i = 0; i < len; i++) {
            System.out.println(stack1 + ":" + stack2);

            final char ch = s.charAt(i);
            if (ch == '(') {
                stack1.push(i);
                count1++;
            } else if (ch == ')') {
                count2++;
                stack2.push(i);
            } else {
                // do nothing
            }
            System.out.println(stack1 + ":" + stack2);
            if (count2 > count1) {
                for (int kk = 0; kk < stack2.size(); kk++) {
                    if (modified) {
                        // final List<String> temp = new LinkedList<String>(op);
                        int index = 0;
                        for (final String oo : op) {
                            final StringBuilder builder = new StringBuilder(oo);
                            builder.deleteCharAt(stack2.get(kk) - deletedCount);
                            System.out.println(builder.toString());
                            op.add(index, builder.toString());
                            // temp.add(builder.toString());
                            index++;
                        }
                        // op = temp;
                    } else {
                        final StringBuilder builder = new StringBuilder(s);
                        builder.deleteCharAt(stack2.get(kk));
                        System.out.println(builder.toString());
                        op.add(builder.toString());
                    }
                }
                stack1.removeAllElements();
                stack2.removeAllElements();
                count1 = 0;
                count2 = 0;
                deletedCount++;
            }
        }
        if (count1 != count2) {

            for (int kk = 0; kk < stack1.size(); kk++) {
                final List<String> temp = new LinkedList<String>();
                for (final String oo : op) {
                    final StringBuilder builder = new StringBuilder(oo);
                    System.out.println(oo);
                    builder.deleteCharAt(stack1.get(kk) - deletedCount);
                    System.out.println(builder.toString());
                    temp.add(builder.toString());
                }
                op = temp;
            }

        }
        return op;
    }
}
