package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-03 10:37
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author:Kaka
 * @Description: 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * @Date: 2023/4/3 10:37
 */
public class TheThirdMaxNum {
    //排序+双指针
    //从大到小排序，左指针指向最左边的数，右指针往后移
    //计数器count用来记录左指针移动的次数
    //当右指针指向的数与左指针指向的数不同时，移动左指针并count++
    //注意返回的结果为左指针指向的元素
    public int thirdMax(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        System.out.println(Arrays.toString(nums));
        int left = 0;
        for(int right = left+1; right < nums.length; right++){
            if(nums[right] != nums[left]){
                left = right;
                count++;
            }
            if(count ==2) break;
        }

        return count == 2? nums[left]:nums[0];
    }

    public static void main(String[] args) {
        TheThirdMaxNum test = new TheThirdMaxNum();
        int[] nums = {2,2,3,1};
        int res = test.thirdMax(nums);
        System.out.println(res);

    }
}