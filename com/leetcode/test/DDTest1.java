package com.leetcode.test;

import java.util.*;

public class DDTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long sum = 0L;
        for (int i : arr) sum += i;
        int left = 0, right = n - 1;
        while (right >= left) {
            double avg = sum / (double) (right - left + 1);
            if (avg * k >= arr[right]) {
                break;
            }
            double l = Math.abs(avg - arr[left]);
            double r = Math.abs(avg - arr[right]);
            if (l < r) {
                sum -= arr[right--];
            } else {
                sum -= arr[left++];
            }

        }
        System.out.println(right - left + 1);
    }

    void func() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        double avg = 0;
        Arrays.sort(arr);
        long sum = 0L;
        int left = 0, right = 0;
        for (int i : arr) sum += i;
        int res = 0;
        while (right < n) {
            sum += right;
            avg = sum / (double) (right - left + 1);
            if (avg * k >= arr[right]) {
                right++;
            } else {
                sum -= arr[left++];
            }
            res = Math.max(res, right - left + 1);
        }
        System.out.println(right - left + 1);
    }
}
