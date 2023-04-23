package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-07 15:16
 */

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/7 15:16
 */
public class Find132pattern {
    public boolean find132pattern(int[] nums) {
        //O(N^3)超时
        //遍历 暂存当前元素为temp，对该元素之后的所有元素利用双指针进行遍历，左指针寻找大于temp的值
        //找到移动右指针至左指针之后，寻找大于temp和右指针的数，找到返回true
        int len = nums.length;
        if (len < 3) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            int left = i + 1;
            for (; left < len; left++) {
                if (nums[left] > nums[i]) {
                    int right = left + 1;
                    for (; right < len; right++) {
                        if (nums[left] > nums[right] && nums[right] > nums[i]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }
    public boolean find132pattern2(int[] nums) {
        //遍历 使用双指针
        // 在left的右边 查找比 left大的数
        // 然后在left 和 right之间查找比 right大的数
        int len = nums.length;
        int left = 0;
        for (int right = 2 ; left < len && right < len; right++) {
            int target = left;
            if (nums[right] <= nums[left]) {
                right++;
                continue;
            }
            while (left < right) {
                left++;
                if (nums[left] > nums[right]) {
                    return true;
                }
            }
            left = target;
            if (right + 1 == len) {
                left++;
                right = left+1;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Find132pattern find132pattern = new Find132pattern();
        int[] nums = {3,1,4,2};
        boolean pattern = find132pattern.find132pattern2(nums);
        System.out.println(pattern);
    }
}
