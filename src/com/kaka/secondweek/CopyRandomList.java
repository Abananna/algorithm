package com.kaka.secondweek;/**
 * @author kkstart
 * @create 2023-04-13 09:17
 */

import com.kaka.secondweek.resource.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:Kaka
 * @Description:
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 */
public class CopyRandomList {
    //深拷贝 在内存中复制一个与原来结构完全一致的链表
    //需要保存原节点中random指针指向结点的位置，在新节点中模拟相应的位置。
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //在原链表每个结点后面复制一个新节点
        Node p = head;
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        //将新链表的random指针指向原链表节点random.next
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        //将链表分离 得到目标链表
        p = head;
        Node dummy = new Node(-1);
        Node cur = dummy;
        while (p != null) {
            cur.next = p.next;
            cur = p.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;
    }

    //利用hash表 原结点作为key 新节点作为value
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        //原结点作为key，新结点作为value放入map中
        while (p != null) {
            Node newNode = new Node(p.val);
            map.put(p, newNode);
            p = p.next;
        }
        //
        p = head;
        while (p != null) {
            Node newNode = map.get(p);
            if (p.next != null) {
                newNode.next = map.get(p.next);
            }
            if (p.random != null) {
                newNode.random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }
}
