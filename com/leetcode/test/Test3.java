package com.leetcode.test;


import java.util.*;

public class Test3 {

    static List<Res> list;
    static char[] vals;
    static Res[] arr;

    public static void main(String[] args) {
        list = null;
        vals = null;
        arr = null;
        int[] tree = new int[(int)1e6];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        tree[1] = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        for (int i = 1; i < n; i++) {
            int temp = sc.nextInt();
            int idx = map.get(temp);
            idx *= 2;
            if (tree[idx] != 0) idx++;
            tree[idx] = i + 1;
            map.put(i + 1, idx);
        }
        vals = sc.next().toCharArray();
        list = new LinkedList<>();
        arr = new Res[n];
        dfs(tree, 1);
        for (Res res : arr) {
            System.out.printf(res.set.size() + " ");
        }
    }

    public static void dfs(int[] tree, int idx) {
        if (idx >= (int)1e6 || tree[idx] == 0) return;
        Set<Character> set = new HashSet<>();
        Res res = new Res();
        res.set = set;
        res.id = tree[idx];
        list.add(res);
        for (Res res1 : list) {
            res1.set.add(vals[tree[idx] - 1]);
        }
        dfs(tree, idx * 2);
        dfs(tree, idx * 2 + 1);
        arr[res.id - 1] = res;
        list.remove(res);
    }
    static class Res {
        Set<Character> set;
        int id;
    }
}
