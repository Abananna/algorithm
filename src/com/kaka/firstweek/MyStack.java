package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-01 10:58
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author:Kaka
 * @Description: 用队列来实现栈
 * @Date: 2023/4/1 10:58
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x){
        queue1.offer(x);
    }

    public int pop() {//出栈并返回栈顶元素
        this.top();//获取栈顶元素 即queue的队尾元素
        int res = queue1.poll();//栈顶元素出队
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return res;
    }

    public int top() { //获取队尾元素 将除队尾元素外的其他元素转移到队列2 再对队列1进行出队操作
        while (queue1.size() > 1){
            queue2.offer(queue1.poll());
        }
        return queue1.peek();
    }

    public boolean empty(){
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}
