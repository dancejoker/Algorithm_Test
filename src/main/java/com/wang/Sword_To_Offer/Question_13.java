package com.wang.Sword_To_Offer;

/**
 * 在 O （1）时间删除链表结点
 * 题目：给定单向链表的头指针和一个结点指针，定义一个函数在 O(1)时间删除
 * 该结点。
 * Created by ddp on 2018/2/23.
 */
public class Question_13 {
    private static class ListNode{
        int data;
        ListNode nextNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode second = new ListNode();
        ListNode third = new ListNode();
        head.nextNode = second;
        second.nextNode = third;
        head.data = 1;
        second.data = 2;
        third.data = 3;
        Question_13 p13 = new Question_13();
        p13.deleteNode(head, second);
        System.out.println(head.nextNode.data);
    }
    public void deleteNode(ListNode head,ListNode deListNode) {
        if(deListNode == null||head == null) {
            return;
        }
        if(head == deListNode) { //删除头结点
            head = null;
        } else {
            if(deListNode.nextNode == null) { //删除尾结点
                ListNode pointListNode = head;
                while(pointListNode.nextNode.nextNode != null) {
                    pointListNode = pointListNode.nextNode;
                }
                pointListNode.nextNode = null;
            } else {
                deListNode.data = deListNode.nextNode.data;
                deListNode.nextNode = deListNode.nextNode.nextNode;
            }
        }
    }
}
