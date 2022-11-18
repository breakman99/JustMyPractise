package com.leetcode.test;
import java.util.*;

public class WYTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        for (int i = 0; i < n; i++) b[i] = sc.nextInt();
        int[] arr1 = new int[n - 1];
        int[] arr2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr1[i] = a[i + 1] - a[i];
            arr2[i] = b[i + 1] - b[i];
        }
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int temp = 0, max = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr1[i] == arr2[i]) {
                temp++;
            } else {
                temp = 0;
            }
            max = Math.max(max, temp);
        }
        System.out.println(max + 1);
    }
}