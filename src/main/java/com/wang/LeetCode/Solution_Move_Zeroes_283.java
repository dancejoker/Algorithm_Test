package com.wang.LeetCode;

/**
 * Created by ddp on 2018/2/17.
 */
public class Solution_Move_Zeroes_283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,0,5,10,0,2,0,20};
        new Solution_Move_Zeroes_283().moveZeroes(array);
        for(int num: array)
            System.out.print(num + " ");
    }
}
