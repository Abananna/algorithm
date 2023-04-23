package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-19 08:39
 */

import com.kaka.thirdweek.resource.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/19 08:39
 */
public class SerializeTree {
    //Encode Tree
        //bfs
    public String Serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        str.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                str.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else{
                str.append("null");
            }
            str.append(",");
        }
        str.append("]");
        return str.toString();
    }

    //Decode Tree
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] str = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//根结点入队
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!"null".equals(str[i])){
                node.left = new TreeNode(Integer.parseInt(str[i]));//构造树的左孩子
                queue.offer(node.left);
            }
            i++;
            if (!"null".equals(str[i])) {
                node.right = new TreeNode(Integer.parseInt(str[i]));//构造树的右孩子
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }


    //以下为本题的深搜解法
    //Encode
    public String serialize1(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "," + serialize1(root.left) + "," + serialize1(root.right);
    }

    //Decode
    public TreeNode deserialize1(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        return dfs(queue);
    }

    private TreeNode dfs(Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = dfs(queue);
        root.right = dfs(queue);
        return root;
    }
}