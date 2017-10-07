package com.wang.LeetCode;

/**
 * Created by ddp on 2017/10/5.
 */
public class Solution_Non_decreasing_Array_665 {
    public boolean checkPossibility(int[] nums) {
        boolean flag = false;
        int i = 1;
        while(i < nums.length){
            if(nums[i - 1] > nums[i]){
                if(flag)
                    return false;
                flag = true;
                if(i - 2 < 0 || nums[i - 2] < nums[i]) nums[i - 1] = nums[i];
                else nums[i] = nums[i - 1];
            }
            ++i;
        }
        return  true;
    }

    public static void main(String[] args) {
        int[] num = {3,4,2,3};
        System.out.println(new Solution_Non_decreasing_Array_665().checkPossibility(num));
    }
}
