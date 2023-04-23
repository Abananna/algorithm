package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-12 08:58
 */

import java.util.PriorityQueue;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/12 08:58
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
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
