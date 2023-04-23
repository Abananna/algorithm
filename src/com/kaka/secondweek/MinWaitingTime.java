package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-15 13:49
 */

import java.util.Arrays;

/**
 * @Author:Kaka
 * @Description:  最小化排队等待时间
 *  有 n 个人在等待办理事务，其中第 i 个人的事务需要 w[i] 分钟完成。现在希望你安排他们办理事务的顺序，从而使得每个人的等待时间之和最小，并返回最小的排队等待时间总和。
 * @Date: 2023/4/15 13:49
 */
public class MinWaitingTime {
    public int minimumWaitingTime(int[] w) {
            Arrays.sort(w);
            int perWaiting = 0;
            int sumWaiting = 0;
            for (int i = 1; i < w.length ; i++) {
                // 1 2 3
                // 0 1 3  = 4
                // 1 3 5 7 9  =
                // 0 1 4 9 16 = 30
                perWaiting += w[i - 1];
                sumWaiting += perWaiting;
            }
            return sumWaiting;
    }
}
