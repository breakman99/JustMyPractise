package com.leetcode.subject;

import java.util.ArrayList;
import java.util.List;

public class No236 {
    List<List<TreeNode>> list = new ArrayList<>(2);
    List<TreeNode> temp = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        List<TreeNode> a = list.get(0);
        List<TreeNode> b = list.get(1);
        int x = 0, y = 0;
        while (x + 1 < a.size() && y + 1 < b.size()) {
            if (a.get(++x) == b.get(++y)) break;
        }
        return a.get(x);
    }
    void dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return;
        temp.add(node);
        if (node.val == p.val || node.val == q.val) {
            list.add(new ArrayList<>(temp));
        }
        dfs(node.left, p, q);
        dfs(node.right, p, q);
        temp.remove(node);
    }
}
