package com.leetcode.test;

public class Test1 {
    public static void main(String[] args) {
        Test1 t = new Test1();
        for (int i = 1; i < 10; i++) {
            t.test(i);
        }
    }

    public void test(int num) {
        int[] arr = new int[num + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= num; i++) {
            int left = i - 1;
            int right = 0;
            while (left >= 0) {
                arr[i] += (arr[right++] * arr[left--]);
            }
        }
        System.out.println(arr[num]);
    }
}
