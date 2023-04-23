package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-01 14:03
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Kaka
 * @Description: 给定一维数组，求数组中 从左往右 每个数字 第一次 出现的位置。如果是 第一次 出现则返回 -1。
 * @Date: 2023/4/1 14:03
 */
public class FirstAppearLocation {
    public int[] find_left_repeat_num(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
                res[i] = -1;
            } else {
                res[i] = map.get(nums[i]);
            }
        }
        return res;
    }
    public int[] find_left_repeat_num1(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int location = -1;
            for (int j =0; j < i; j++){
                if(nums[j] == nums[i]) {
                    location = j;
                    break;
                }
            }
            res[i] = location;
        }
        return res;
    }
}
