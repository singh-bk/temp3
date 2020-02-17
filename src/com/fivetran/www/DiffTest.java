package com.fivetran.www;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiffTest {

    public int maxSubjectNumber(List<Integer> answered, List<Integer> remaining, int q) {
        int count = 0;
        final List<Integer> diff = new ArrayList<Integer>();
        int index = 0;
        for(final int ii: remaining) {
            diff.add(ii - answered.get(index));
            index++;
        }
        
        Collections.sort(diff);
        int total = 0;
        for(final int xx: diff) {
            if(xx < 0) continue;
            total = total + xx;
            if(total <= q ) count++;
            else break;
        }
        return count;
    }
}
