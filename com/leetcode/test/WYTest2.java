package com.leetcode.test;
import java.util.*;

public class WYTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long m = num;
        int n = 1;
        double now = 0, max = 0;
        long res1 = 0, res2 = 0;
        for (int i = 1; ; i++) {
            n = i;
            double temp =  Math.pow(m, i);
            double temp2 = temp / Math.pow(n, n);
            if (temp2 > now) {
                res1 = (long) temp;
                res2 = (long) Math.pow(n, n);
                now = temp2;
            } else {
                break;
            }
        }
        System.out.println(res1 + " " + res2);
    }
}
