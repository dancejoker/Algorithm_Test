package com.wang.Sword_To_Offer;

/**
 * 问题：二维数组中的查找
 * 题目描述：一个二维数组，每一行从左到右递增，每一
 * 列从上到下递增．输入一个二维数组和一个整数，判断
 * 数组中是否含有整数
 * Created by ddp on 2018/2/21.
 */
public class Question_3 {
    public static boolean find(int[][] matrix,int target){
        if(matrix == null || matrix.length == 0)
            return false;
        int column = matrix[0].length - 1;
        int row = 0;
        while(row < matrix.length && column >= 0){
            if(matrix[row][column] == target)
                return true;
            if(matrix[row][column] > target)
                column--;
            else
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] testarray=new int[4][4];
        testarray[0][0]=1;
        testarray[0][1]=2;
        testarray[0][2]=8;
        testarray[0][3]=9;
        testarray[1][0]=2;
        testarray[1][1]=4;
        testarray[1][2]=9;
        testarray[1][3]=12;
        testarray[2][0]=4;
        testarray[2][1]=7;
        testarray[2][2]=10;
        testarray[2][3]=13;
        testarray[3][0]=6;
        testarray[3][1]=8;
        testarray[3][2]=11;
        testarray[3][3]=15;
        System.out.println(find(testarray, 1));
    }
}
