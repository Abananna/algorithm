package com.kaka.thirdweek.resource;/**
 * @author kkstart
 * @create 2023-04-18 09:13
 */

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/18 09:13
 */
 public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     TreeNode() {}
     public TreeNode(int val) { this.val = val; }
     public TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
