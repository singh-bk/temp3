package com.leetcode.atlassian;

import java.util.Stack;

public class DecodeString2 {
    public static void main(String[] args) {

        final String input = "2[a2[b]c]3[cd]ef";
        final DecodeString2 obj = new DecodeString2();
        System.out.println(obj.decodeString(input));
    }
    
    public String decodeString(String s) {
        
        
        final Stack<String> stack = new Stack<String>();
        final int len = s.length();
        int i=0;
        while(i < len) {
            final char ch = s.charAt(i);
            if(ch !=']') {
                stack.push(ch+"");
            }else {
                final StringBuilder builder = new StringBuilder();
                String ss = stack.peek();
                while(!ss.equals("[")) {
                    ss = stack.pop();
                    builder.insert(0, ss);
                    ss = stack.peek();
                }
                stack.pop();
                final int times = Integer.parseInt(stack.pop());
                final StringBuilder temp = new StringBuilder("");
                for(int k=0;k<times;k++) {
                    temp.append(builder);
                }
                stack.push(temp.toString());
            }
            i++;
        }
        
        final StringBuilder op = new StringBuilder();
        while(!stack.isEmpty()) {
            final String sst = stack.pop();
            System.out.println(sst);
            op.insert(0,sst);
        }
        
        return op.toString();
    }
}
