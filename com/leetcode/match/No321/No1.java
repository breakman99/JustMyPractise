package com.leetcode.match.No321;

public class No1 {
    public int pivotInteger(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        int m = 0;
        for (int i = 0; i <= n; i++) {
            m += i;
            if (m == sum) return i;
            sum -= i;
        }
        return -1;
    }
}
