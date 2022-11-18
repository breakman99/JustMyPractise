package com.leetcode.subject;

import java.util.Arrays;

public class NoTest2 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,3},{4,5,6},{7,8,9}
        };
        new NoTest2().test(3, arr);
    }

    public void test(int n, int[][] arr) {
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= mid; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[n - j - 1][i];
                arr[n - j - 1][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }

}



// 1
class A {
    private A() {
        System.out.println("a");
    }
    static A a = new A();
    public static A getInstance() {
        return a;
    }
}

// 2 饿汉式写法
class B {
    private B() {
        System.out.println("b");
    }
    private static B b;
    public static B getInstance() {
        if (b == null) {
            synchronized (B.class) {
                if (b == null) {
                    b = new B();
                }
            }
        }
        return b;
    }
}





















