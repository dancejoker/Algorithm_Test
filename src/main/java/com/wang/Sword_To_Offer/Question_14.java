package com.wang.Sword_To_Offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该函数数组中数字的顺序，使得
 * 所有奇数位于数组的前半部分，所有的数组位于数组的后半部分
 * Created by ddp on 2018/2/23.
 */
public class Question_14 {
    public static void main(String args[]) {
        int[] array= {1,2,3,4,5,6,7};
        Question_14 test=new Question_14();
        test.order(array);
        for(int item:array)
            System.out.println(item);
    }
    public void order(int[] array) {
        if(array == null || array.length == 0)
            return ;
        int start=0;
        int end=array.length - 1;
        while(start < end) {
            while(start < end && !isEven(array[start])) {
                start++;
            }
            while(start < end && isEven(array[end])) {
                end--;
            }
            if(start < end) {
                array[start] = array[start] + array[end];
                array[end] = array[start] - array[end];
                array[start] = array[start] - array[end];
            }
        }
    }
    private boolean isEven(int n) {
        return (n & 0x1) == 0;
    }
}
