package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-21 15:03
 */

import com.kaka.thirdweek.resource.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/21 15:03
 */
public class DistanceK {
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
    List<Integer> ans = new ArrayList<Integer>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 从 root 出发 DFS，记录每个结点的父结点
        findParents(root);

        // 从 target 出发 DFS，寻找所有深度为 k 的结点
        findAns(target, null, 0, k);

        return ans;
    }

    // 递归查找每个结点的父结点，并将其保存在 parents 中
    public void findParents(TreeNode node) {
        if (node.left != null) {
            parents.put(node.left.val, node);
            findParents(node.left);
        }
        if (node.right != null) {
            parents.put(node.right.val, node);
            findParents(node.right);
        }
    }

    // 递归查找所有深度为 k 的结点
    public void findAns(TreeNode node, TreeNode from, int depth, int k) {
        if (node == null) {
            return;
        }
        if (depth == k) {
            ans.add(node.val); // 如果深度为 k，则将当前节点的值加入到 ans 中
            return;
        }
        if (node.left != from) {
            // 如果左子节点不是来自 from（即不是从父节点访问过来的），则继续遍历左子树，并把深度加一
            findAns(node.left, node, depth + 1, k);
        }
        if (node.right != from) {
            // 如果右子节点不是来自 from（即不是从父节点访问过来的），则继续遍历右子树，并把深度加一
            findAns(node.right, node, depth + 1, k);
        }
        if (parents.get(node.val) != from) {
            // 如果当前节点的父节点不是来自 from（即不是从子节点访问过来的），则向上回溯一层，继续查找
            findAns(parents.get(node.val), node, depth + 1, k);
        }
    }
}
