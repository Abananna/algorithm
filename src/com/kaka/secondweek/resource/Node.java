package com.kaka.secondweek.resource;/**
 * @author kkstart
 * @create 2023-04-13 09:16
 */

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/13 09:16
 */
public class Node {
    public  int val;
    public Node next;
    public Node random;

    public Node (int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
