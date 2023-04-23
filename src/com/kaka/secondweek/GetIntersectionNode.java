package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-11 10:02
 */

import com.kaka.secondweek.resource.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Kaka
 * @Description:
 * @Date: 2023/4/11 10:02
 */
public class GetIntersectionNode {
    //扫描两组链表 确认各链表的长度，将短链表的结点位置和下一结点的内存地址 存到一个hash表中
    //遍历长链表，记录其位置，判断在hash表中是否还有与其内存地址相同的结点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode preA = headA;
        ListNode preB = headB;
        while (preA != preB) {
            preA = preA != null ? preA.next : headB;
            preB = preB != null ? preB.next : headA;
        }
        return preA;
    }
}
