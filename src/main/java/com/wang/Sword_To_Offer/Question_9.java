package com.wang.Sword_To_Offer;

/**
 * 斐波那契数列
 * 写一个函数，输入 n，求斐波那契数列的第 n 项。时间复杂度 （O(n)）
 * Created by ddp on 2018/2/21.
 */
public class Question_9 {
    public long fibonacci(int n) {
        long result = 0;
        long preOne = 1;
        long preTwo = 1;
        if(n == 0) {
            return preOne;
        }
        if(n == 1) {
            return preTwo;
        }
        for(int i = 2; i <= n; i++) {
            result = preOne+preTwo;
            preOne = preTwo;
            preTwo = result;
        }
        return result;
    }

    public static void main(String[] args) {
       long sum = new Question_9().fibonacci(4);
        System.out.println(sum);
    }
}
