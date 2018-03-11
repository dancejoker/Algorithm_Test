package com.wang.Sword_To_Offer;

/**
 * 链表中倒数第 k  个结点
 * 题目：输入一个链表，输出该链表中倒数第 k 个结点。为了符合大多数人的习惯，
 * 本题从 1 开始计数，即链表的尾结点是倒数第一个结点。例如一个有 6 个结点的
 * 链表，从头结点依次是 1,2,3,4，5,6。倒数第三个结点就是值为 4 的结点。
 * Created by ddp on 2018/2/23.
 */
public class Question_15 {
    public static class ListNode {
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
        Question_15 test = new Question_15();
        ListNode resultListNode = test.findKToTail(head, 3);
        System.out.println(resultListNode.data);
    }
    public ListNode findKToTail(ListNode head,int k) {
        if(head  == null||k  == 0) {
            return null;
        }
        ListNode resultNode = null;
        ListNode headListNode = head;
        for(int i = 0; i < k - 1; ++i) {
            if(headListNode.nextNode != null) {
                headListNode = headListNode.nextNode;
            } else {
                return null;
            }
        }
        resultNode = head;
        while(headListNode.nextNode != null) {
            resultNode = resultNode.nextNode;
            headListNode = headListNode.nextNode;
        }
        return resultNode;
    }
}
