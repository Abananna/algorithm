package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-14 14:54
 */

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/14 14:54
 */
public class MergeSort {
    public void sort(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
    }
    //划分数组
    private void mergeSort(int[] nums, int left, int right) {
        if(left >= right)
            return;
        int mid = (left + right)/2;
        //分解左半部分数组
        mergeSort(nums, left, mid);
        //分解右半部分数组
        mergeSort(nums, mid + 1, right);
        //合并数组
        merge(nums, left, mid, right);
    }
    private void merge(int[] nums, int left, int mid,int right) {
        int[] temps = new int[nums.length];
        //找到最左边的元素
        int lPos = left;
        //找到右第一个元素
        int rPos = mid + 1;
        //临时数组的下标
        int pos = left;
        //进行合并
        while (lPos <= mid && rPos <= right) {
            if (nums[lPos] < nums[rPos]) {
                temps[pos++] = nums[lPos++];
            } else {
                temps[pos++] = nums[rPos++];
            }
        }
        //合并左边剩余元素
        while (lPos <= mid) {
            temps[pos++] = nums[lPos++];
        }
        //合并右边剩余元素
        while (rPos <= right) {
            temps[pos++] = nums[rPos++];
        }
        //把临时数组中合并后中的元素拷贝到原数组
        while (left <= right) {
            nums[left] = temps[left];
            left++;
        }
    }

}
