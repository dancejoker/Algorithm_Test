package com.wang.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 题目：
 * 2n个数字分成n组，每组2个数字，取每组中较小的数字，求和。
 * 要求是得到的和最大，方法返回值即为这个最大和。
 * Created by ddp on 2018/2/17.
 */
public class Solution_Array_Partition_561 {
    public int arrayPairSum(Integer[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        // 逆序，sort函数不能用基本类型，sort()的第一个参数是
        //泛型，泛型遇见基本类型，基本类型不会出现自动转换为包装类
//        Arrays.sort(nums,Collections.reverseOrder());
        for(int i=0; i<nums.length; i+=2)
            sum += nums[i];

        return sum;
    }

    public static void main(String[] args) {
        Integer[] arrays = {1,4,3,2};
        System.out.println(new Solution_Array_Partition_561().arrayPairSum(arrays));
    }
}
