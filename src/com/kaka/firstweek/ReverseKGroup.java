package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-06 08:58
 */


import java.util.ListIterator;

/**
 * @Author:Kaka
 * @Description: 给你链表的头节点 head ，每k个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

 * @Date: 2023/4/6 08:58
 */
public class ReverseKGroup {
    //k个一组反转
    //初步思路 迭代使用双指针 分块反转链表
    //不断维护旧块的尾指针.next
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //pre每次要反转的链表的头结点的上一节点
        ListNode pre = dummy;
        //end每次要反转的链表的尾结点
        ListNode end = dummy;

        while (end.next != null) {
            //判断每个分区内结点的数量是否满足k个
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            //不满足则break；
            if (end == null) {
                break;
            }
            //满足则记录当前分区链表的尾结点的next,然后断开
            ListNode next = end.next;
            end.next = null;
            //start指向每次要反转的链表的头结点
            ListNode start = pre.next;
            //pre指向反转链表的头结点的上一结点 链接两个块链表
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode rear = head;

        while (rear != null) {
            ListNode temp = rear.next;
            rear.next = pre;
            pre = rear;
            rear = temp;
        }
        return pre; //返回链表的尾结点
    }
}

