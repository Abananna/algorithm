package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-14 13:45
 */

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/14 13:45
 */
public class MissingNumber {
    //等差数列通项公式
    public int missingNumber(int[] nums) {
        int len = nums.length;
        // 0 1 2 3 等差数列  和为 6  通项公式为
        int target = len*(1+len)/2;
        int sum = 0;
        for (int num : nums) {
            sum -= num;
        }
       return sum;

    }

    //异或
    public int missingNumber2(int[] nums) {
        int len = nums.length;
        int ans = 0;
        for (int num : nums) {
            ans ^=num;
        }
        for (int i = 0; i <= nums.length; i++) {
            ans ^= i;
        }
        return ans;
    }
}
