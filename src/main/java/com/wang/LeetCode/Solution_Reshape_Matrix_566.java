package com.wang.LeetCode;

/**
 * Created by ddp on 2018/2/17.
 */
public class Solution_Reshape_Matrix_566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int original_r = nums.length;
        int original_c = nums[0].length;
        if (original_r * original_c == r * c) {
            int[][] result = new int[r][c];
            for (int i = 0; i < r * c; i++) {
                result[i / c][i % c] = nums[i / original_c][i % original_c];
            }
            return result;
        } else {
            return nums;
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        nums = new Solution_Reshape_Matrix_566().matrixReshape(nums,2,6);
        for(int i = 0; i < nums.length;++i){
            for(int j = 0;j < nums[0].length;++j){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
