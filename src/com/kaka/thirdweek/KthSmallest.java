package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-20 09:34
 */

import com.kaka.thirdweek.resource.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/20 09:34
 */
public class KthSmallest {
    //方法一：朴素做法，中序遍历树，存到list中，取第k-1个值
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
    //中序遍历 保存到list中，然后取值
        if (root == null) {
            return -1;
        }
        dfs(root);
        return list.get(k+1);
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
    //方法一改进 充分利用二叉搜索树特性
    int K , res;

    public int kthSmallest2(TreeNode root, int k) {
        k = k;
        dfs2(root);
        return res;
    }
    private void dfs2(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs2(node.left);
        if (--K == 0) {
            res = node.val;
        }
        dfs2(node.right);
    }

    //方法二
    public int kthSmallest1(TreeNode root, int k) {
        //先统计左子节点的个数
        int leftCount = countNodes(root.left);
        if (leftCount >= k) {
            //如果左子节点的个数大于等于k，说明我们要找的元素就在左子节点中，
            //直接在左子节点中查找即可
            return kthSmallest1(root.left, k);
        } else if (leftCount + 1 == k) {
            //如果左子节点的个数加当前节点（1）正好等于k，说明根节点
            //就是要找到元素
            return root.val;
        } else {
            //否则要找的元素在右子节点中，到右子节点中查找
            return kthSmallest1(root.right, k - 1 - leftCount);      // 关键是这句，对右子树的查找
        }
    }

    //统计节点个数
    public int countNodes(TreeNode n) {
        if (n == null)
            return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
}
