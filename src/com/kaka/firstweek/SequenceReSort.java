package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-09 09:10
 */

import java.util.*;

/**
 * @Author:Kaka
 * @Description: 给定长度为偶数的整数数组 nums，再对 nums 进行 m 轮如下操作：
         * 依次将 nums 中的每个元素交替插入栈和队列中，下标为偶数的插入栈中，反之插入队列中（数组下标从 0 开始）。
         * 将队列中所有数出队，组成一个序列。再将栈中所有数出栈，接在之前的序列后面，这样得到长度与 nums 相同的新序列，并用其更新 nums。
         * 求 m 轮操作以后 nums 的第 kth 个数。
 * @Date: 2023/4/9 09:10
 */
public class SequenceReSort {
    public int solve(int[] nums, int m, int kth) {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int n = 0; n < m; n++) {
            for (int i = 0; i < nums.length; i++) {
                if (i % 2 == 0) {
                    stack.push(nums[i]);
                } else {
                    queue.offer(nums[i]);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (!queue.isEmpty()) {
                    nums[i] = queue.poll();
                    continue;
                }
                nums[i] = stack.pop();
            }
        }

        return nums[kth - 1];
    }

    //上述方法timeout
    public int solve2(int[] nums, int m, int thk) {
        thk--;
        int len = nums.length;
        while (m > 0) {
            if (thk < len / 2) {
                thk = 2 * thk + 1;
            } else {
                thk = 2 * (len - thk - 1);
            }
            m--;
        }
        return nums[thk];
    }
    public static void main(String[] args) {
        SequenceReSort s = new SequenceReSort();
        int[] nums = {1,4,5,8};
        System.out.println(s.solve2(nums, 1, 4));
    }

}
