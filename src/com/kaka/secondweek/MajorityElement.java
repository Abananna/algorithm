package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-13 10:27
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/13 10:27
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums) {
            if (map.get(num) > len / 2) {
                return num;
            }
        }
        return -1;
    }
    //还可以通过排序+双指针解决

    //技巧法 由于是超过一半的数，所以最中位数即为目标值
}
