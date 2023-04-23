package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-03 11:46
 */

import java.util.Arrays;

/**
 * @Author:Kaka
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @Date: 2023/4/3 11:46
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int left =0, right =1;
        while(right < nums.length){
            //左指针为0右指针不为0 进行赋值操作
            if(nums[left] == 0 && nums[right] != 0) {
                nums[left++] = nums[right];
                nums[right++] = 0;
            } else if(nums[left] ==0 && nums[right] == 0) {
                //左右指针均为0 左指针不动，右指针后移
                right++;
            } else if(nums[left] != 0) {
                //左指针不为0 左右指针均后移
                left++;
                right++;
            }
        }
    }
    public void moveZeroes1(int[] nums) {
        int left =0;
        //只要右指针不为0 就将值赋给左指针
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        //左指针开始往后补0
        for(int i = left; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] nums = {0,1,0,3,12};
        moveZeros.moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
