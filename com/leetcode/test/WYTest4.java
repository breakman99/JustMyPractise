package com.leetcode.test;
import java.util.*;
public class WYTest4 {

    static Set<Integer> set;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 方格总数
        int w = sc.nextInt();
        // 画笔类数量
        int n = sc.nextInt();
        int[] type = new int[n];
        for (int i = 0; i < n; i++) {
            type[i] = sc.nextInt();
        }
        arr = new int[w];
        dfs(0, type, 0);
        System.out.println(set.size());
        List<Integer> list = new ArrayList<>(set);
        list.sort((Comparator.comparingInt(o -> o)));
        for (int i = 0; i < list.size(); i++) {
            System.out.printf((list.get(i) + 1) + " ");
        }

    }

    static void dfs(int position, int[] type, int typePos) {
        // first judgement
        if (typePos == type.length - 1) {
            boolean[] te = new boolean[type.length];
            boolean fla = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) te[arr[i] - 1] = true;
            }
            for (int i = 0; i < te.length; i++) {
                if (te[i] == false) fla = false;
            }
            if (fla) {
                Set<Integer> tempSet = new HashSet<>();
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] != 0) tempSet.add(i);
                }
                if (set == null) set = new HashSet<>(tempSet);
                else set.retainAll(tempSet);
            }
        }
        // 1 add now
        if (typePos < type.length && position + type[typePos] <= arr.length && (position - 1 < 0 || arr[position - 1] == 0)) {
            for (int i = position; i < position + type[typePos]; i++) arr[i] = typePos + 1;
            dfs(position + type[typePos], type, typePos);
            for (int i = position; i < position + type[typePos]; i++) arr[i] = 0;
        }
        // 2 add null
        if (typePos < type.length && position + 1 < arr.length) {
            dfs(position + 1, type, typePos);
        }
        // 3 add next
        if (typePos + 1 < type.length && position + type[typePos + 1] <= arr.length && (position - 1 < 0 || arr[position - 1] == 0)) {
            for (int i = position; i < position + type[typePos + 1]; i++) arr[i] = typePos + 2;
            dfs(position + type[typePos + 1], type, typePos + 1);
            for (int i = position; i < position + type[typePos + 1]; i++) arr[i] = 0;
        }
    }
}
