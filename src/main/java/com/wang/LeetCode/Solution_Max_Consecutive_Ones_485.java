package com.wang.LeetCode;

/**
 * 给定一个二进制数组，计算数组中出现的最大连续1的个数。
 * Created by ddp on 2018/2/17.
 */
public class Solution_Max_Consecutive_Ones_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for(int i : nums){
            sum = (sum + i) * i;
            if(max < sum) max = sum;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1,1,0,1,1};
        int max = new Solution_Max_Consecutive_Ones_485().findMaxConsecutiveOnes(nums);
        System.out.println(max);
    }
}
