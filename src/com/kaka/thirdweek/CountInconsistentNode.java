package com.kaka.thirdweek;

import com.kaka.thirdweek.resource.TreeNode;

/**
 * 统计不一致结点个数
 * @author kaka
 */
public class CountInconsistentNode {
    //统计俩二叉树结点的总数sum1，相同的节点数sum2；作差即为目标数
    public int countInconsistentNode(TreeNode root1, TreeNode root2) {
        int sum = dfs(root1) + dfs(root2);

        return sum - dfs(root1, root2) * 2;

    }

    /**
     * 统计总的节点数
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 1;
        count += dfs(root.left);
        count += dfs(root.right);
        return count;
    }

    /**
     * 查找同一位置上的相同元素
     * @param root1
     * @param root2
     * @return
     */
    private int dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return 0;
        }
        if(root1 == null || root2 == null) {
            return 0;
        }
        int count = 0;
        if (root1.val == root2.val) {
            count++;
        }
        count += dfs(root1.left, root2.left);
        count += dfs(root1.right, root2.right);

        return count;
    }
}
