package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-14 16:22
 */

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/14 16:22
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > nums[mid - 1]) l = mid;
            else r = mid - 1;
        }
        return r;
    }
}
