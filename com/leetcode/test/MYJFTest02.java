package com.leetcode.test;
import java.util.*;
public class MYJFTest02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n - 1; i++)
            arr[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
        Deque<Node> deque = new LinkedList<>();
        deque.addLast(new Node(0, 0));
        int res = 0;
        while (!deque.isEmpty()) {
            Node node = deque.removeFirst();
            int num = node.num;
            int add = node.add;
            res += num - add;
            for (int i = 0; i < n; i++) if (arr[num][i] != 0) deque.addLast(new Node(i, num));
        }
        System.out.println(res);
    }
    static class Node {
        int num;
        int add;
        public Node(int num, int add) {
            this.num = num;
            this.add = add;
        }
    }
}
/**
 * 7
 * 1 2
 * 1 3
 * 1 4
 * 2 5
 * 2 6
 * 3 7
 *
 * void func() {
 *         Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         int res = 0;
 *         for (int i = 0; i < n - 1; i++)
 *             res += -1 * (sc.nextInt() - sc.nextInt());
 *
 *         System.out.println(res);
 *     }
 *
 */