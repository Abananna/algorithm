package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-07 16:44
 */

import sun.misc.Queue;

import java.util.*;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/7 16:44 ——————>16:54————————>15:15
 */
public class SumOfIndex {
    public int[] solve(int[] nums) {
        //用一个map维护数组nums[i]出现的次数和下标
        //map的value为一个数组用,来维护坐标和 和出现的次数；
        //这里算出的结果为前五次出现的角标之和 题意理解有误
        Map<Integer, int[]> map = new HashMap<>();
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int[] temp = new int[]{i, 1};
                map.put(nums[i],temp);
                res[i] = -1;
            } else {
                int sumFre = map.get(nums[i])[1];
                int sumIndex = map.get(nums[i])[0];
                if (sumFre < 5) {
                    map.put(nums[i],new int[]{sumIndex + i,sumFre+1});
                    res[i] = -1;
                    continue;
                }
                res[i] = sumIndex;
            }
        }
        return res;
    }

    //以下为正确解题过程
    public int[] solve2(int[] nums) {
        //Map来存储元素的值和近五次出现的下标
        //近五次出现的下标用队列来存储
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            ArrayList<Integer> indexQueue = map.getOrDefault(nums[i], new ArrayList<>());
            if (indexQueue.size() < 5) {
                res[i] = -1;
                indexQueue.add(i);
                map.put(nums[i], indexQueue);
            } else {
                int count = 0;
                for (int j = indexQueue.size() - 1; j >= indexQueue.size() - 5; j--) {
                    count += indexQueue.get(j);
                }
                res[i] = count;
                indexQueue.add(i);
                map.put(nums[i], indexQueue);
            }
        }
        return res;
    }
    public int[] solve3(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            ArrayList<Integer> list = hashMap.getOrDefault(nums[i], new ArrayList<Integer>());
            if (list.size() < 5) {
                arr[i] = -1;
                list.add(i);
                hashMap.put(nums[i],list);
            }else {
                int count = 0;
                for (int j = list.size() -1; j >= list.size() -5 ; j--) {
                    count += list.get(j);
                }
                arr[i] = count;
                list.add(i);
                hashMap.put(nums[i],list);
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SumOfIndex sumOfIndex = new SumOfIndex();
        int[] nums = new int[]{1,1,1,1,1,1};
        System.out.println(Arrays.toString(sumOfIndex.solve2(nums)));
    }
}
