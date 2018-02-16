package com.wang.LeetCode;

/**
 * 从左上角到右下角的每个对角线上的元素是否相等,若相等返回true
 * Created by ddp on 2018/2/17.
 */
public class Solution_Toeplitz_Matrix_766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        boolean flag = new Solution_Toeplitz_Matrix_766().isToeplitzMatrix(matrix);
        System.out.println(flag);
    }
}
