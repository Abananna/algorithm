package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-05 13:51
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/5 13:51
 */
public class ReverseList {
    //迭代法 从头到尾迭代
    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        ListNode p = head;
        while (p != null) {
            node = new ListNode(p.val, node);
            p = p.next;
        }
        return node;
    }
    //双指针
    public ListNode reverseList2(ListNode head){
        ListNode pre = null;
        ListNode rear = head;
        while (rear != null) {
            ListNode temp = rear.next;
            rear.next = pre;
            pre = rear;
            rear = temp;
        }
        return pre;
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
