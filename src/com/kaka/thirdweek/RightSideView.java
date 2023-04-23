package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-18 09:46
 */

import com.kaka.thirdweek.resource.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/18 09:46
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
       //bfs
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); //根结点放入队列
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {//for循环的目的在于找出当前层的最后一个元素
                TreeNode node = queue.poll();//取出队列中的结点
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    //dfs
    List<Integer> result = new ArrayList<>();
    List<Integer> rightSideVideDFS(TreeNode root) {
        dfs(root, 0);
        return result;
    }
    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
