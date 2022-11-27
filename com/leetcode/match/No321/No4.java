package com.leetcode.match.No321;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class No4 {
    public static void main(String[] args) {
        System.out.println(new No4().countSubarrays(new int[]{5,19,11,15,13,16,4,6,2,7,10,8,18,20,1,3,17,9,12,14}, 6));
    }

    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        int idx = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (k == nums[i]) idx = i;
            else if (nums[i] < k) arr[i]++;
            else arr[i]--;
        }
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = idx - 1; i >= 0; i--) {
            arr[i] += arr[i + 1];
            map1.put(arr[i], map1.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = idx + 1; i < n; i++) {
            arr[i] += arr[i - 1];
            map2.put(arr[i], map2.getOrDefault(arr[i], 0) + 1);
        }
        for (int i : arr) {
            if (i == 0 || i == -1) res++;
        }
        PriorityQueue<Integer[]> q1 = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        PriorityQueue<Integer[]> q2 = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            q1.add(new Integer[]{entry.getKey(), entry.getValue()});
        }
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            q2.add(new Integer[]{entry.getKey(), entry.getValue()});
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Integer[] a = q1.peek(), b = q2.peek();
            if (a[0] + b[0] == 0 || a[0] + b[0] == -1) {
                res += (a[1] * b[1]);
                q1.remove();
                q2.remove();
                if (q1.isEmpty() && !q2.isEmpty()) {
                    q1.add(a);
                    continue;
                } else if (q2.isEmpty() && !q1.isEmpty()) {
                    q2.add(b);
                    continue;
                } else if (!q1.isEmpty() && !q2.isEmpty()){
                    Integer[] c = q1.peek(), d = q2.peek();
                    if (a[0] + d[0] == 0 || a[0] + d[0] == -1) res += (a[1] * d[1]);
                    if (c[0] + b[0] == 0 || c[0] + b[0] == -1) res += (c[1] * b[1]);
                }
            } else if (a[0] + b[0] >= 0) q1.remove();
            else q2.remove();
        }
        return res;
    }
}
