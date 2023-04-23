package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-11 09:08
 */

import com.kaka.secondweek.resource.ListNode;

/**
 * @Author:Kaka
 * @Description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Date: 2023/4/11 09:08
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        int size;
        //第一遍扫描获取链表的长度
        for (size = 0; pre.next != null; size++) {
            pre = pre.next;
        }
        // 1 2 3 4 5    那么5 - 2 = 3
        pre = dummy;
        for(int i = 0; i < size - n; i++) {
            pre = pre.next;
        }
        if(pre.next == null){
            return null;
        }
        ListNode temp = pre.next;
        pre.next = temp.next;
        return dummy.next;
    }
}
