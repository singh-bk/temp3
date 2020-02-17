package com.leetcode.twilio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Temp {

    public static void main(String[] args) {
        final String input =
                        "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis partu sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore ver rup. Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa.";
        System.out.println(segments(input));
    }

    public static List<String> segments(String message) {
        final List<String> op = new ArrayList<String>();
        int n = 0;
        if (message.length() <= 160) {
            op.add(message);
        } else {
            final StringTokenizer tokens = new StringTokenizer(message, " ");
            StringBuilder builder = new StringBuilder("");
            int currentLen = 0;
            String token = null;
            int currentIndex = 1;

            while (tokens.hasMoreTokens()) {
                token = tokens.nextToken();
                if (currentLen + token.length() <= 154) {
                    builder.append(token);
                    builder.append(" ");
                    currentLen = currentLen + token.length() + 1;
                } else {
                    builder.append(" (" + currentIndex + "/n)");
                    currentLen = 0;
                    currentIndex++;
                    op.add(builder.toString());
                    builder = new StringBuilder("");
                    builder.append(token);
                    n++;
                }

            }
            if (builder.length() > 0) {
                builder.append(" (" + currentIndex + "/n)");
                op.add(builder.toString());
            }
        }
        System.out.println(n);

        final Iterator<String> iter = op.iterator();
        final List<String> op2 = new ArrayList<String>();
        final int size = op.size();
        if (n > 0) {
            int xxx = 1;
            while (iter.hasNext()) {
                final String str = iter.next();
                str.lastIndexOf(" (" + xxx + "/n)");
                if (xxx < size) {
                    op2.add(str.replace(" (" + xxx + "/n)", " (" + xxx + "/" + size + ")"));
                } else {
                    final String stttt = str.replace("  (" + xxx + "/n)", "(" + xxx + "/" + size + ")");
                    System.out.println(str);
                    System.out.println(stttt);
                    op2.add(str.replace("  (" + xxx + "/n)", "(" + xxx + "/" + size + ")"));
                }
                xxx++;
            }
        } else {
            op2.add(op.get(0));
        }
        System.out.println(op2);
        return op;
    }
}
