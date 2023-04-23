package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-01 10:32
 */

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/1 10:32
 */
public class DynamicArr {
    int[] arr;
    int curSize;
    int maxSize;

    public DynamicArr() {
        this.arr= new int[1];
        this.curSize = 0;
        this.maxSize = 1;
    }

    public void push_back(int n) {
        if(curSize == maxSize) {
            this.maxSize *= 2;
            int[] temp = new int[maxSize];
            for(int i = 0; i < curSize; i++){
                temp[i] = arr[i];
            }
            this.arr = temp;
        }
        arr[curSize++]=n;
    }

    public void pop_back() {
        curSize--;
    }

    public int size() {
        return curSize;
    }

    public int index(int idx) {
        return arr[idx];
    }
}
