package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-09 10:11
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author:Kaka
 * @Description:
 * 给定的二维整数数组 types，types[i][0] = 0 表示第 i 个数据结构为栈，types[i][0] = 1 表示第 i 个数据结构为队列，types[i][1] 表示第 i 个数据结构的大小。
 *再给定数组 nums，并依次将 nums 中的每个元素插入到第 1 个数据结构中。
 *如果第 i 个数据结构已满，则第 i 个数据结构出队（出栈）一个元素并将该元素插入至第 i+1 个数据结构中。(若 i+1 > types.length，则将该元素「输出」)，再将本来要插入至第 i 个数据结构的元素插入至第 i 个数据结构中。
 * 请返回第 kth 个「输出」的数。
 *
 * @Date: 2023/4/9 10:11
 */
public class LineStructComb {
    public int solve(int[][] types, int[] nums, int kth) {
        int len = types.length;
        int swallowNums = 0; //栈中被吞的元素的数量 = 栈容量 - 1
        for (int i = 0; i < len; i++) {
            if (types[i][0] == 0) {
                swallowNums += types[i][1] - 1;
            }
        }
        return nums[swallowNums + kth - 1];
    }
}
