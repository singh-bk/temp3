package com.fivetran.www;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeavesTest {

    public static List<Long> autumnLeaves(List<Integer> leaves, int percentages, List<Integer> day,
                                             List<Integer> starting, List<Integer> ending) {
        
        final List<Long> op = new ArrayList<Long>();
        
        
        final int maxDay = Collections.max(day);
        final int[][] fallenLeavesOnGivenDay = new int[day.size()][maxDay+1];
        
        
        for(int i=0;i<day.size();i++) {
            int leavesOnPrevDay = leaves.get(i);
            for(int j=1;j<=maxDay;j++) {
                fallenLeavesOnGivenDay[i][j] = (int)Math.ceil((leavesOnPrevDay*percentages)/100);
                leavesOnPrevDay = (int)Math.ceil((leavesOnPrevDay*(100-percentages))/100);
            }
        }
        
        for(int i=0;i<day.size();i++) {
            long count = 0l;
            for(int x=starting.get(i); x<=ending.get(i);x++) {
                count = count + fallenLeavesOnGivenDay[i][x];
            }
            op.add(count);
        }
        
        return op;
        
    }
}
