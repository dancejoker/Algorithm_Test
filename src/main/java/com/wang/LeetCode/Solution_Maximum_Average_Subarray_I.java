package com.wang.LeetCode;

/**
 * Created by ddp on 2017/10/9.
 */
public class Solution_Maximum_Average_Subarray_I {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i = 0;i < k;++i)
            sum += nums[i];
        int max = sum;
        for(int i = k; i < nums.length;++i){
            sum += nums[i] - nums[i - k];
            max = Math.max(sum,max);
        }
        return (double)max/k;
    }


    public static void main(String[] args) {
        int[] nums ={1,12,-5,-6,50,3};
        int k = 4;
        double maxAverage = new Solution_Maximum_Average_Subarray_I().findMaxAverage(nums, k);
        System.out.println(maxAverage);
    }
}
