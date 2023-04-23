package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-03 13:37
 */

import java.security.Key;
import java.util.*;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/3 13:37
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //双指针
        int left = 0;
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int right = k - 1; right < nums.length; right++) {
            //用一个tempNum记录左指针指向位置的元素，当left <= right时右移
            int tempNum = nums[left];
            int tempIndex = left;
            //在移动的过程中比较当前指向元素和tempNum的值大小
            while (left < right) {
                left++;
                if (nums[left] > tempNum) {
                    tempNum = nums[left];
                }
            }
            list.add(tempNum);
            left = tempIndex + 1;
            sum = sum + tempIndex;
        }
        int[] maxNums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            maxNums[i] = list.get(i);
        }
        return maxNums;
    }
    //官方题解
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        //优先队列 大顶堆 维护最大值
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            // 若是优先队列/最大堆的堆顶元素 不在滑动窗口范围内，则直接从优先队列中进行删除
            // while循环结束条件 ：即，当优先队列/最大堆的堆顶元素 在滑动窗口之内的话，则将该元素加入到ans结果数组中;
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, 3);
        System.out.println(Arrays.toString(ints));
    }
}
