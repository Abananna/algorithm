package com.kaka.thirdweek;

import com.kaka.thirdweek.resource.TreeNode;

/**
 * 给定一棵二叉查找树的根结点 root，求其中值等于 val 的结点个数。
 * @author kaka
 */
public class CountNodes {

    public int count = 0;
    public int countNodes(TreeNode root, int val) {
        dfs(root, val);
        return count;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            count++;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }
}
