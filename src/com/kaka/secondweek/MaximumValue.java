package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-16 10:07
 */

import java.util.Arrays;

/**
 * @Author:Kaka
 * @Description: 最大价值
 * 给定整数数组 nums 和 arr，定义 arr 中每个数的「价值」为 nums 中比该数大的元素个数与比该数小的元素个数之积，求 arr 中「价值」最大的数的 「价值」，并将结果对 1e9+7 取模。
 * @Date: 2023/4/16 10:07
 */
public class MaximumValue {
    //二分法 求取有序数组nums中比arr[i]大的数的开始坐标和比arr[i]小的数的开始坐标
    //
    public int maximumValue(int[] nums, int[] arr) {
        Arrays.sort(nums);
        int res = -1;
        for (int num : arr) {
            int multi = binarySearch(nums, num);
            res = multi > res ? multi : res;
        }

        return res % (1000000000+7);
    }

    private int binarySearch(int[] nums, int target) {
        //找到最后一个小于target的数的索引
        int left = -1, right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) >> 1;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
       int lessIndex = left >= 0 ? left + 1 : 0;
        //找到第一个大于target的数的索引
        left = -1;
        right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) >> 1;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int greaterIndex = nums.length - right;

        return lessIndex * greaterIndex;
    }
}
