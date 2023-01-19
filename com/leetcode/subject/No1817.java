package com.leetcode.subject;

import java.util.HashMap;
import java.util.*;

public class No1817 {
}


/**
 * 输入：logs = [[0,5],[1,2],[0,2],[0,5],[1,3]], k = 5
 * 输出：[0,2,0,0,0]
 */
class No1817_Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> activeMinutes = new HashMap<Integer, Set<Integer>>();
        for (int[] log : logs) {
            int id = log[0], time = log[1];
            activeMinutes.putIfAbsent(id, new HashSet<Integer>());
            activeMinutes.get(id).add(time);
        }
        int[] answer = new int[k];
        for (Set<Integer> minutes : activeMinutes.values()) {
            int activeCount = minutes.size();
            answer[activeCount - 1]++;
        }
        return answer;
    }
}
