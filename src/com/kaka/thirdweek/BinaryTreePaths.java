package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-20 11:54
 */

import com.kaka.thirdweek.resource.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/20 11:54
 */
public class BinaryTreePaths {
    List<String> list;
    String str;
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        list = new ArrayList<>();
        str = "";
        preDfs(root, str);
        return list;
    }

    private void preDfs(TreeNode node, String str) {
        if (node == null) {
           return;
        }
        StringBuffer pathSB = new StringBuffer(str);
        pathSB.append(node.val);
        if (node.left == null && node.right == null) {
            list.add(pathSB.toString());
        } else {
            pathSB.append("->");
            preDfs(node.left, pathSB.toString());
            preDfs(node.right, pathSB.toString());
        }
    }

}
