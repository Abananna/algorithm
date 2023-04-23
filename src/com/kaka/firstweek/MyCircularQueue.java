package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-01 13:12
 */

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/1 13:12
 */
public class MyCircularQueue {
    int[] arr;
    int head; //队头指针
    int tail; //队尾指针
    int maxLen; //队列最大长度
    int len; //队列当前元素个数

    public MyCircularQueue(int k) {
        arr = new int[k];
        this.maxLen = k;
    }

    public boolean enQueue(int value) {
        if(isFull())
            return false;
        arr[tail++] = value;
        tail %= maxLen;
        len++;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty())
            return false;
        head = (head+1) % maxLen;
        len--;
        return true;
    }

    public int Front() {
        if(isEmpty())
            return -1;
        return arr[head];
    }

    public int Rear() {
        if(isEmpty())
            return -1;
        int realTail = (tail - 1 + maxLen) % maxLen;
        return arr[realTail];
    }

    public boolean isEmpty() {
        return len==0;
    }

    public boolean isFull() {
        return len==maxLen;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
