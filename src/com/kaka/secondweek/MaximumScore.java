package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-16 14:38
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/16 14:38
 */
public class MaximumScore {
    public int maximumSource(int atk, int[][] monsters) {
        //首先将二维数组中的防御值全部取出放到一个有序数组中，并保存二维数组的下标和防御值之间的映射（map）
        int len = monsters.length;
        int[] dArr = new int[len];//dArr保存第i个怪兽的防御值
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i <len; i++) {
            map.put(monsters[i],i);
            dArr[i] = monsters[i][0];
        }
        Arrays.sort(dArr);
        if (atk < dArr[0]) {
            return -1;
        }
        int score = 0;
        for (int i = 0; i < len; i++) {
            if (atk < dArr[i]) {
                return score;
            }
//            map.containsKey(map.ge)[]
//            atk +=
        }
        return -1;
    }
}
