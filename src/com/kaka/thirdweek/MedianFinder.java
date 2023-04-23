package com.kaka.thirdweek;/**
 * @author kkstart
 * @create 2023-04-22 09:25
 */

import java.util.PriorityQueue;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/22 09:25
 */
public class MedianFinder {

    PriorityQueue<Integer> queueL;
    PriorityQueue<Integer> queueR;

    public MedianFinder() {
        //大根堆优先队列,堆顶维护数据流中位数左边的最大值
        queueL = new PriorityQueue<>((a,b) -> b-a);
        //小根堆优先队列,堆顶维护数据流中位数右边的最大值
        queueR = new PriorityQueue<>((a,b) -> a-b);
    }

    public void addNum(int num) {
        int lSize = queueL.size();
        int rSize = queueR.size();
        if (lSize == rSize) {
            if (queueR.isEmpty() || num <= queueR.peek()) {
                queueL.add(num);
            } else {
                queueL.add(queueR.poll());
                queueR.add(num);
            }
        } else {
            if (queueL.peek() <= num) {
                queueR.add(num);
            } else {
                queueR.add(queueL.poll());
                queueL.add(num);
            }
        }
    }

    public double findMedian() {
        int lSize = queueL.size();
        int rSize = queueR.size();
        if (lSize == rSize) {
            return (queueL.peek() + queueR.peek()) / 2.0;
        } else {
            return queueL.peek();
        }
    }
}
