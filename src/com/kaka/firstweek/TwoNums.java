package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-01 13:39
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Kaka
 * @Description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * @Date: 2023/4/1 13:39
 */
public class TwoNums {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target -nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
