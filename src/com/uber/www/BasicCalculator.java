package com.uber.www;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        final BasicCalculator obj = new BasicCalculator();
        String s = "(1+(4+5+2)-3)+(6+8)";
        s = "1+1";
        System.out.println(obj.calculate2(s));
    }

    public int calculate2(String s) {
        s = s.replaceAll(" ", "");
        final char[] ch = s.toCharArray();


        final Stack<String> stack = new Stack<String>();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(ch[i] + "");
            } else if (ch[i] == ')') {
                final Stack<String> temp = new Stack<String>();
                String str = stack.pop();
                while (!str.equals("(")) {
                    temp.add(str);
                    str = stack.pop();
                }
                int start = -99999;
                int end = -99999;
                char opp = 0;
                while (!temp.isEmpty()) {
                    final String ss = temp.pop();
                    if (ss.charAt(0) == '+' || ss.charAt(0) == '-') {
                        opp = ss.charAt(0);
                    } else if (start == -99999) {
                        start = Integer.parseInt(ss);
                    } else if (end == -99999) {
                        end = Integer.parseInt(ss);
                        if (opp == '+') start = start + end;
                        if (opp == '-') start = start - end;
                        end = -99999;
                    }
                }
                stack.push(start + "");
            } else if (ch[i] == '+' || ch[i] == '-') {
                stack.push(ch[i] + "");
            } else {
                int currentNumber = Integer.parseInt(ch[i] + "");
                int j = i + 1;

                while (j<ch.length && ch[j] != '(' && ch[j] != ')' && ch[j] != '-' && ch[j] != '+') {
                    currentNumber = currentNumber * 10 + Integer.parseInt(ch[j] + "");
                    j++;
                }
                i=j-1;
                stack.push(currentNumber + "");
            }
        }
        System.out.println(stack);
        final int len = stack.size();
        final String[] ll = new String[len];
        int idx = len - 1;

        while (!stack.isEmpty()) {
            ll[idx] = stack.pop();
            idx--;
        }

        final int total = 0;
        int start = -99999999;
        int end = -1;
        char op = 0;
        for (int i = 0; i < len; i++) {
            if (ll[i].length() == 1 && (ll[i].charAt(0) == '+' || ll[i].charAt(0) == '-')) {
                op = ll[i].charAt(0);
            } else if (start == -99999999) {
                start = Integer.parseInt(ll[i]);
            } else {
                end = Integer.parseInt(ll[i]);
                if (op == '+') start = start + end;
                if (op == '-') start = start - end;
            }
        }

        return start;
    }


    public int calculate(String s) {
        final char[] ch = s.toCharArray();
        int start = -1;
        int end = -1;
        char op = 0;
        final Stack<String> stack = new Stack<String>();
        boolean lastPushed = false;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(ch[i] + "");
            } else if (ch[i] == ')') {
                stack.push(start + "");
                String ss = stack.pop();
                final Stack<String> st2 = new Stack<String>();
                while (!ss.equals("(")) {

                    st2.add(ss);
                    ss = stack.pop();
                }
                int stNested = -1;
                int endNested = -1;
                char opNested = 0;
                while (!st2.isEmpty()) {
                    final String temp = st2.pop();
                    if (temp.charAt(0) == '+' || temp.charAt(0) == '-') {
                        opNested = temp.charAt(0);
                    } else if (stNested == -1) {
                        stNested = Integer.parseInt(temp);
                    } else {
                        endNested = Integer.parseInt(temp);
                        if (opNested == '+') {
                            stNested = stNested + endNested;
                        } else if (opNested == '-') {
                            stNested = stNested - endNested;
                        }

                    }
                }
                if (stack.isEmpty()) {
                    start = stNested;
                } else {
                    stack.push(stNested + "");
                    lastPushed = true;
                }
            } else if (ch[i] == '+') {
                if (start != -1 && end != -1) {
                    if (op == '+') {
                        start = start + end;
                    } else if (op == -1) {
                        start = start - end;
                    }
                    end = -1;
                }
                if (!stack.isEmpty()) {
                    if (!lastPushed) {
                        stack.push(start + "");
                    }
                    stack.push(ch[i] + "");
                    start = -1;
                    end = -1;
                }
                op = '+';
            } else if (ch[i] == '-') {
                if (start != -1 && end != -1) {
                    if (op == '+') {
                        start = start + end;
                    } else if (op == -1) {
                        start = start - end;
                    }
                    end = -1;
                }
                if (!stack.isEmpty()) {
                    if (!lastPushed) {
                        stack.push(start + "");
                    }
                    stack.push(ch[i] + "");
                    start = -1;
                    end = -1;
                }
                op = '-';
            } else {
                lastPushed = false;

                if (start == -1) {
                    start = Integer.parseInt(ch[i] + "");
                } else if (op == 0) {
                    start = start * 10 + Integer.parseInt(ch[i] + "");
                } else if (end == -1) {
                    end = Integer.parseInt(ch[i] + "");
                } else {
                    end = end * 10 + Integer.parseInt(ch[i] + "");
                }
            }
        }
        return -1;
    }
}
