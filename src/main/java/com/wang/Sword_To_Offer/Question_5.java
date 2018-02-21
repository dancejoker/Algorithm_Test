package com.wang.Sword_To_Offer;

import java.util.Stack;

/**
 *  从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个结点的值。
 * Created by ddp on 2018/2/21.
 */
public class Question_5 {
    private static class ListNode{
        int data;
        ListNode next;
    }
    public static void main (String args[]) {
        ListNode node1=new ListNode();
        ListNode node2=new ListNode();
        ListNode node3=new ListNode();
        node1.data=1;
        node2.data=2;
        node3.data=3;
        node1.next=node2;
        node2.next=node3;
        Question_5 test=new Question_5();
        test.printListReverse(node1);
    }
    public static void printListReverse(ListNode headNode) {
        Stack<ListNode> stack=new Stack<ListNode>();
        while(headNode!=null) {
            stack.push(headNode);
            headNode=headNode.next;
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop().data);
        }
    }
}
