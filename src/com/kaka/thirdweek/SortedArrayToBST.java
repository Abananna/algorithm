package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-20 11:31
 */

import com.kaka.thirdweek.resource.TreeNode;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/20 11:31
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return inorder(nums, 0, nums.length - 1);
    }

    private TreeNode inorder(int[] nums, int left, int right) {
        //每次选择中间的数为结点，两边的数为左右孩子
        if (left > right) {
            return null;
        }
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = inorder(nums, left, mid - 1);
        root.right = inorder(nums, mid + 1, right);

        return root;
    }
}
