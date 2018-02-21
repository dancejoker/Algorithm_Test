package com.wang.Sword_To_Offer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 题目描述：用两个栈实现一个队列，实现对了的两个函数 appendTail 和
 * deleteHead，分别完成在队列尾插入结点和在队列头部删除结点的功能。
 * Created by ddp on 2018/2/21.
 */
public class Question_7<T> {
    private Stack<T> stack1=new Stack<T>();
    private Stack<T> stack2=new Stack<T>();
    public void appendTail(T t) {
        stack1.push(t);
    }

    public T deleteHead() throws Exception {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()) {
            throw new Exception("队列为空，不能删除");
        }
        return stack2.pop();
    }
    public static void main(String args[]) throws Exception {
        Question_7<String> p7=new Question_7<>();
        p7.appendTail("1");
        p7.appendTail("2");
        p7.appendTail("3");
        p7.deleteHead();
    }
}
