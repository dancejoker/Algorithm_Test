package com.wang.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ddp on 2017/10/4.
 */
public class Solution_Two_Sum_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num ={2, 7, 11, 15};
        int target = 9;
        int[] nums = new Solution_Two_Sum_1().twoSum(num, target);
        for(int number : nums){
            System.out.print(number + " ");
        }
    }
}
