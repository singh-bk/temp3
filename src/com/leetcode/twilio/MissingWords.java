package com.leetcode.twilio;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MissingWords {

    public static void main(String[] args) {
        final String input = "I am using hackerrank to improve improve programming programming";
        final String sub = "am hackerrank to improve programming";
        final MissingWords obj = new MissingWords();
        System.out.println(obj.missingWords(input, sub));
    }
    
    public List<String> missingWords(String input, String sub){
        final List<String> op = new ArrayList<String>();
        final StringTokenizer first = new StringTokenizer(input, " ");
        final StringTokenizer second = new StringTokenizer(sub, " ");
        String ff = null;
        String ss = null;
        boolean proceed = true;
        while(first.hasMoreTokens()) {
            ff = first.nextToken();
            if(proceed && second.hasMoreTokens()) {
                ss = second.nextToken(); 
            }
            if(ff.equals(ss)) {
                proceed = true;
                ss = null;
            }else {
                proceed = false;
                op.add(ff);
            }
        }
        return op;
    }
}
