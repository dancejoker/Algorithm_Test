package com.wang.Sword_To_Offer;

/**
 * 打印 1  到最大的 n  位数
 * 题目：输入数字 n，按顺序打印出从 1 到最大的 n 位进制数。比如输入 3，则打
 * 印出 1、2、3 一直到 999.
 * Created by ddp on 2018/2/22.
 */
public class Question_12 {
    public static void main(String[] args) {
        Question_12 p12 = new Question_12();
        p12.printToMaxOfNDigits(3);
    }

    public void printToMaxOfNDigits(int n) {
        int[] array = new int[n];
        if (n <= 0)
            return;
        printArray(array, 0);
    }

    private void printArray(int[] array, int index) {
        for (int i = 0; i < 10; i++) {
            if (index != array.length) {
                array[index] = i;
                printArray(array, index + 1);
            } else {
                boolean isFirstNo0 = false;
                for (int j = 0; j < array.length; j++) {
                    if (array[j] != 0) {
                        System.out.print(array[j]);
                        if (!isFirstNo0)
                            isFirstNo0 = true;
                    } else {
                        if (isFirstNo0)
                            System.out.print(array[j]);
                    }
                }
                System.out.println();
                return;
            }
        }
    }
}
