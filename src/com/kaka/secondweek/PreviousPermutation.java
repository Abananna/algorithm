package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-15 14:47
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author:Kaka
 * @Description: 上一个排列
 * 实现获取 上一个排列 的函数，算法需要将给定数字序列重新排列成字典序中上一个更小的排列。
 * 注意：如果不存在前一个更小的排列，则将数字重新排列成最大的排列（即降序排列）。
 * @Date: 2023/4/15 14:47
 */
public class PreviousPermutation {
    public int[] previousPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums;
        }
        int i = len - 1;
        //寻找第一个nums[i-1] > nums[i]的位置
        while ( i > 0) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
            i--;
        }
        //i==0说明给定数组是增大的有序数组
        if (i == 0) {
            reverse(nums, 0, len - 1);
            return nums;
        }
        int temp = i;
        //寻找第一个大于目标位置元素的位置
        while (temp < len) {
            if (nums[temp] >= nums[i]) {
                break;
            }
            temp++;
        }
        swap(nums, i - 1, temp - 1);
        reverse(nums, i, len - 1);
        return nums;
    }

    public void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap (nums, l++, r--);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        PreviousPermutation p = new PreviousPermutation();
        int[] nums = {1,33,14,25,3,4,2,2,26,18,10,26,20,19,15,26,10,12,26,14,3,5,28,22,27,21,11,32,32,24,20,2,25,14,23,28,31,33,1,12,28,26,4,30,27,29,13,2,18,2,26,21,20,19,23,29,19,14,31,33,21,2,20,33,6,20,24};

        System.out.println(Arrays.toString(p.previousPermutation(nums)));
    }
}
