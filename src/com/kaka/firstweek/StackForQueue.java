package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-03 09:41
 */

import java.util.Stack;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/3 09:41
 */
public class StackForQueue {
    //两个栈实现队列
    // peek时将stack1中所有的元素pop并push到stack2 然后对stack2进行peek
    // peek后恢复原栈以便push时能否push到栈头（队尾）
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public StackForQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
       if(empty())
           return -1;
       //将栈底的元素移到栈顶
        while (!empty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
       return res;

    }

    public int peek() {
        if(empty())
            return -1;
        //
        while (!empty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.peek();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return res;
    }
    public boolean empty() {
        return stack1.size()==0;
    }
}
