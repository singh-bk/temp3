package com.leetcode.salesforce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterPhone {

    public static void main(String[] args) {
        final LetterPhone obj = new LetterPhone();
        System.out.println(obj.letterCombinations("+14157088956"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> op = new ArrayList<String>();
        final Map<Integer, String> mappings = new HashMap<Integer, String>();
        mappings.put(1, "");
        mappings.put(2, "abc");
        mappings.put(3, "def");
        mappings.put(4, "ghi");
        mappings.put(5, "jkl");
        mappings.put(6, "mno");
        mappings.put(7, "pqrs");
        mappings.put(8, "tuv");
        mappings.put(9, "wxyz");
        mappings.put(0, " ");
        
        final int len = digits.length();
        
        for(int i=1;i< len;i++) {
            final int digit = Integer.parseInt(digits.charAt(i)+"");
            if(op.isEmpty()) {
                final String str = mappings.get(digit);
                for(int j=0;j<str.length();j++) {
                    op.add(str.charAt(j)+"");
                }
            }else {
                final String str = mappings.get(digit);
                final List<String> temp = new ArrayList<String>();
                for(final String opStr: op) {
                    for(int kk =0;kk<str.length();kk++) {   
                        temp.add(opStr + str.charAt(kk));
                    }
                }
                op = temp;
            }
        }
        
        return op;
    }
}
