package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-04 11:01
 */

import java.util.*;

/**
 * @Author:Kaka
 * @Description: 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 *               返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 * @Date: 2023/4/4 11:01
 */
public class MinColOfNums {
    //遍历 用hashMap存储元素及其出现的次数
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if(numsMap.containsKey(arr[i])) {
                numsMap.put(arr[i], numsMap.get(arr[i]) + 1);
            }else {
                numsMap.put(arr[i], 1);
            }
        }
        System.out.println(numsMap);
        //遍历map中的value
        List<Integer> list = new ArrayList<>(numsMap.values());
        list.sort((o1, o2) -> o2 - o1);
        int count = 0;
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp += list.get(i);
            if (temp < len / 2) {
                count++;
            } else if(temp >= len/2) {
                count++;
                break;
            }
        }
        return count ;
    }

    public static void main(String[] args) {
        MinColOfNums minColOfNums = new MinColOfNums();
        int[] nums = new int[]{1,9};
        int res = minColOfNums.minSetSize(nums);
        System.out.println(res);
    }
}
