package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-21 14:32
 */

import com.kaka.thirdweek.resource.TreeNode;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/21 14:32
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {

        if(root == null){
            return 0;
        }
        return dfs(root);
    }
    private int dfs(TreeNode node){
        int res = 0;
        if(node.left != null) {
            res += isLeftBleaf(node.left) ? node.left.val : dfs(node.left);
        }
        if(node.right != null && !isLeftBleaf(node.right)) {
            res += dfs(node.right);
        }
        return res;
    }
    private boolean isLeftBleaf(TreeNode node) {
        return node.left == null && node.right ==null;
    }
}
