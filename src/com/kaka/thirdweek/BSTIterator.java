package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-20 10:25
 */

import com.kaka.thirdweek.resource.TreeNode;

import java.util.*;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/20 10:25
 */
//优化写法
class BSTIterator2 {
    TreeNode cur;
    Stack<TreeNode> stack;
    public BSTIterator2(TreeNode root) {
        this.cur = root;
        this.stack = new Stack<>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;

        return res;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
public class BSTIterator {
    List<Integer> list;
    int cursor;
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        this.cursor = 0;
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public boolean hasNext() {
        return cursor < list.size();
    }

    public int next() {
        return list.get(cursor++);
    }
}
