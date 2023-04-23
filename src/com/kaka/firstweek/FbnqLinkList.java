package com.kaka.firstweek;/**
 * @author kkstart
 * @create 2023-04-08 09:04
 */

/**
 * @Author:Kaka
 * @Description: 给定一个链表的头结点 head，依次取出其第 1, 2, 3, 5, 8, 13, 21...个元素组成新链表(若大于链表实际长度则不需要取出)，并返回新链表的头结点。
 *
 */
public class FbnqLinkList {
    //斐波那契数特点 从第三个数开始 这个数等于前两个数之和 即An = A(n-1) + A(n-2)
    //题目给定的值 小于10^6 斐波那契数第三十位为5.1*10^6
    public ListNode solve(ListNode head) {
        int[] f = new int[30];
        //将前三十个斐波那契数封装在数组中，链表结点的数量在第三十个斐波那契数范围内
        f[0] = 1;f[1] = 2;
        for (int i = 2; i < 30; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        System.out.println(f[29]);
        int idx = 0; //用来控制数组的角标
        int cur = 1; //用来记录移动链表指针的次数
        ListNode dummy = new ListNode(-1);//新链表的头结点
        ListNode pre = dummy;//链接新链表的指针
        while (head != null) {
            //当前指针位置出现在斐波那契数中
            if (cur == f[idx]) {
                //链表指针链到当前位置
                pre.next = head;
                //初始化指针位置
                pre = pre.next;
                idx++;
            }
            head = head.next;
            cur++;
        }
        pre.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        FbnqLinkList fbnqLinkList = new FbnqLinkList();
        ListNode listNode = new ListNode(-1);
        fbnqLinkList.solve(listNode);
    }
}

