package com.leetcode.match.DoubleNo92;

public class No1 {
    public int numberOfCuts(int n) {
        return n % 2 == 0 ? n >> 1 : n;
    }
}
