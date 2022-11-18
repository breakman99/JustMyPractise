package com.leetcode.test;
import java.util.*;

public class PDDTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                String str = sc.next();
                int step = sc.nextInt();
                if ("L".equals(str)) step = -step;
                arr[i] = step;
            }
            int now, step;
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                now = i;
                step = 0;
                Set<Integer> set = new HashSet<>();
                while (now >= 0 && now < n) {
                    if (set.contains(now)) {
                        step = -1;
                        break;
                    }
                    if (res[now] != 0) {
                        if (res[now] == -1) step = -1;
                        else step += res[now];
                        break;
                    }
                    set.add(now);
                    now = now + arr[now];
                    step++;
                }
                res[i] = step;
            }
            for (int i = 0; i < res.length; i++) {
                System.out.printf(res[i] + " ");
            }
            System.out.println();
        }
    }
}