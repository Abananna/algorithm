package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-04 12:48
 */

import java.util.*;

/**
 * @Author:Kaka
 * @Description: 寻找最近的右区间 实质上是在所有区间的左值内寻找离当前区间的右值最近的值 如果存在返回当前区间位置 不存在返回 -1
 * @Date: 2023/4/4 12:48
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> mapLeft = new HashMap<>();
        int[] leftNums = new int[intervals.length];
        //取出所有的interval[i][0],将其值和index的关系用一个map来维护，
        for (int i = 0; i < intervals.length; i++) {
            mapLeft.put(intervals[i][0],i);
            leftNums[i] = intervals[i][0];
        }
        //将值保存到一个有序数组中
        Arrays.sort(leftNums);
        //遍历所有区间，对于每个区间的右值在有序数组中查找大于等于该值的最小数
        //如果存在则在map中取出其对应的index 不存在
        int[] indexNums = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int index = dichotomy(leftNums,intervals[i][1]);
            if (index == -1) {
                indexNums[i] = -1;
                continue;
            }
            indexNums[i] = mapLeft.get(leftNums[index]);
        }
        return indexNums;
    }

    public int dichotomy (int[] nums, int target) {
        if(target > nums[nums.length - 1]){
            return -1;
        }
       int left = -1, right = nums.length;
        while (left + 1 !=  right) {
            int mid = (left + right)/2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        FindRightInterval t1 = new FindRightInterval();
        int[][] nums = {{1,4},{2,3},{3,4}};
        System.out.println(Arrays.toString(t1.findRightInterval(nums)));
    }
}


