package com.leetcode.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TaskScheduler {

    public static void main(String[] args) {
        final char[] tasks = {'A','A','A','B','B','B'};
        final int n=2;
        final TaskScheduler obj = new TaskScheduler();
        System.out.println(obj.leastInterval(tasks, n));
    }

    public int leastInterval(char[] tasks, int n) {
        final List<Character> schedules = new ArrayList<Character>();
        final List<Integer> references = new ArrayList<Integer>(26);
        final List<Integer> spaceReferences = new LinkedList<Integer>();
        for(int i=0;i<26;i++) {
            references.add(-1);
        }
        spaceReferences.add(0);
        System.out.println(references.get(25));
        System.out.println(tasks[3]-65);
        
        for(final int i=0;i<tasks.length;i++) {
            final char ch = tasks[i];
            final int ii = ch-65;
            Integer charReference = references.get(ii);
            if(charReference == -1) {
                charReference = spaceReferences.get(0);
                spaceReferences.remove(0);
                schedules.add(ch);
                spaceReferences.add(schedules.size());
            }else {
                final int jj=0;
                while(true) {
                    final int validSpaceReference = -1;
                    if(spaceReferences.get(jj) > charReference) {
                        
                        final int temp = spaceReferences.get(jj);
                        for(final int tt =0; tt<n;tt++) {
                            if(schedules[])
                        }
                        jj++;
                    }else {
                        jj++;
                    }
                }
            }
        }
        return 0;
    }
}
