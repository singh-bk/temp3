package com.leetcode.atlassian;

public class LookAndSay {

    public static void main(String[] args) {
        final LookAndSay obj = new LookAndSay();
        System.out.println(obj.lookAndSay(30));
    }
    
    public String lookAndSay(int n) {
        //final List<String> ops = new ArrayList<String>();
       // ops.add("1");
       // ops.add("11");
        String prev = "11";
        for(int i=2;i<n;i++) {
            //System.out.println(i);
            //final String prev = ops.get(i-1);
            //System.out.println(prev);
            final int len = prev.length();
            int pp = Integer.parseInt(prev.charAt(0)+"");
            int currentCount =1;
            final StringBuilder builder = new StringBuilder("");
            for(int j=1;j<len;j++) {
                final int nn = Integer.parseInt(prev.charAt(j)+"");
                if(pp == nn) {
                    currentCount++;
                }else {
                    builder.append(currentCount);
                    builder.append(pp);
                    currentCount = 1;
                    pp = nn;
                }
                
            }
            builder.append(currentCount);
            builder.append(pp);
            prev = builder.toString();
            //ops.add(builder.toString());
            //System.out.println(ops);
        }
        //System.out.println(ops);
        System.out.println(prev);
        return prev;
        //return ops.get(n-1);
    }
}
