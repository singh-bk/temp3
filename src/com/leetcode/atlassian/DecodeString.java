package com.leetcode.atlassian;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        final String input = "2[a2[b]c]3[cd]ef";
        final DecodeString obj = new DecodeString();
        System.out.println(obj.decodeString(input));
    }

    public String decodeString(String s) {
        final Stack<String> stack = new Stack<String>();
        int i=0;
        
        while(i<s.length()) {
            if(s.charAt(i) == ']') {
                final StringBuilder builder = new StringBuilder("");
                
                String tt = stack.pop();
                while(!tt.equals("[")) {
                    builder.insert(0, tt);
                    tt = stack.pop();
                }
                final int times = Integer.parseInt(stack.pop());
                final StringBuilder temp = new StringBuilder("");
                for(int xx=0;xx<times;xx++) {
                    temp.append(builder);
                }
                stack.push(temp.toString());
                i++;
            }else {
                stack.push(s.charAt(i)+"");
                i++;
            }
        }
        final StringBuilder bb = new StringBuilder("");
        while(!stack.isEmpty()) {
            bb.insert(0, stack.pop());
        }
        return bb.toString();
        
    }
}
