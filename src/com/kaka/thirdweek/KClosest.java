package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-22 09:47
 */

import java.util.PriorityQueue;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/22 09:47
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        //优先队列（小顶堆）维护一个数组，数组第一个元素是二维数组的下标，第二个元素是距离
        if (points == null) {
            return null;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < points.length; i++) {
            int arr[] = new int[2];
            arr[0] = i;
            arr[1] = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            queue.add(arr);
        }
        int res[][] = new int[k][2];
        while (k > 0) {
            int index = queue.poll()[0];
            res[k-1][0] = points[index][0];
            res[k-1][1] = points[index][1];
            k--;
        }
        return res;
    }
}
