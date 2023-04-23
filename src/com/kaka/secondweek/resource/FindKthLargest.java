package com.kaka.secondweek.resource;/**
 * @author kkstart
 * @create 2023-04-11 10:54
 */

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/11 10:54
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        if (k > len) {
            return -1;
        }
        return nums[len - k];
    }
    //优先队列写法
    //维护整个数组从左到右前k个大的数
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}
