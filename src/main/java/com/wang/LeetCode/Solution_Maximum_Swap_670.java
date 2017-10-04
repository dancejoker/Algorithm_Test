package com.wang.LeetCode;

/**
 * Created by ddp on 2017/10/4.
 */
public class Solution_Maximum_Swap_670 {
    public int maximumSwap(int num) {
        char[] numStr = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for(int i = 0; i < numStr.length; ++i){
            buckets[numStr[i] - '0'] = i;
        }
        for(int i = 0;i < numStr.length;++i){
            for(int k = 9;k > numStr[i] - '0'; --k){
                if(buckets[k] > i){
                    char tmp = numStr[i];
                    numStr[i] = numStr[buckets[k]];
                    numStr[buckets[k]] = tmp;
                    return Integer.valueOf(new String(numStr));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int a = 9973;
        int i = new Solution_Maximum_Swap_670().maximumSwap(a);
        System.out.println(i);
    }
}
