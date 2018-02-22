package com.wang.Sword_To_Offer;

/**
 * 二进制中 1  的个数
 * 题目：请实现一个函数，输入一个整数，
 * 输出该数二进制表示中 1 的个数。
 * Created by ddp on 2018/2/22.
 */
public class Question_10 {
    public static void main(String args[]) {
        Question_10 test=new Question_10();
        System.out.println(test.numberOf1(3));
    }
    public int numberOf1(int n) {
        int count=0;
        while(n!=0) {
            count++;
            n=(n-1) & n;
        }
        return count;
    }
}
