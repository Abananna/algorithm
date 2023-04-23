package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-18 09:14
 */

import com.kaka.thirdweek.resource.TreeNode;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/18 09:14
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

}
