package com.leetcode.subject;

public class No1026 {
}

class No1026Solution {
    int nowMax = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return nowMax;
    }
    public void dfs(TreeNode node, int min, int max) {
        if (node == null) return;
        min = Math.min(node.val, min);
        max = Math.max(node.val, max);
        nowMax = Math.max(max - min, nowMax);
        if (node.left != null) {
            dfs(node.left, min, max);
        }
        if (node.right != null) {
            dfs(node.right, min, max);
        }
    }
}
