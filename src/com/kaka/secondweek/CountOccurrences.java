package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-15 14:01
 */

import java.util.Arrays;

/**
 * @Author:Kaka
 * @Description: 统计出现次数
 * 给定一个有序数组 nums，以及一个目标数 target。返回数组 nums 中 target 的出现次数。
 * 请你实现时间复杂度为 O(logn) 并且只使用 常数级别额外空间 的解决方案。
 * @Date: 2023/4/15 14:01
 */
public class CountOccurrences {
    //找到第一个大于等于目标值的数的坐标 idx1
    //找到第最后一个小于等于目标值的数的坐标 idx2
    //作差就是目标值的个数

    public int CountOccurrences(int[] nums, int target) {
        int left = -1, right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) >> 1;
            //找出第一个大于等于目标值的数
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int idx1 = right;
        left = -1; right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) >> 1;
            //找出最后一个小于等于目标值的数
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int idx2 = left;
        return idx2 - idx1 + 1;
    }
}
