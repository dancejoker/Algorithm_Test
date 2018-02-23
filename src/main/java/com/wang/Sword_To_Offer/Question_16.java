package com.wang.Sword_To_Offer;

/**
 * 反转链表
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的
 * 头结点。
 * Created by ddp on 2018/2/23.
 */
public class Question_16 {
    private static class ListNode {
        int data;
        ListNode nextNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        ListNode forth = new ListNode();
        head.nextNode = second;
        second.nextNode = third;
        third.nextNode = forth;
        head.data = 1;
        second.data = 2;
        third.data = 3;
        forth.data = 4;
        Question_16 test = new Question_16();
        ListNode resultListNode = test.reverseList(head);
        head = resultListNode;
        while (head != null) {
            System.out.println(head.data);
            head = head.nextNode;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.nextNode == null)
            return head;
        ListNode preListNode = null;
        ListNode nowListNode = head;
        ListNode reversedHead = null;
        while (nowListNode != null) {
            ListNode nextListNode = nowListNode.nextNode;
            if(nextListNode == null)
                reversedHead = nowListNode;
            nowListNode.nextNode = preListNode;
            preListNode = nowListNode;
            nowListNode = nextListNode;
        }
        return reversedHead;
    }
}
