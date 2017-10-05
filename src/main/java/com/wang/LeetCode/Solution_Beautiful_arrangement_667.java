package com.wang.LeetCode;

/**
 * Given two integers n and k, you need to construct a list which
 * contains n different positive integers ranging from 1 to n and
 * obeys the following requirement:Suppose this list is
 * [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]
 * has exactly k distinct integers.
 * Created by ddp on 2017/10/5.
 */
public class Solution_Beautiful_arrangement_667 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        for(int i = 0,l = 1,r = n;l <= r;++i){
            if(k == 1)
                res[i] = l++;
            else {
                if (k % 2 != 0)
                    res[i] = l++;
                else
                    res[i] = r--;
                --k;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arraies = new Solution_Beautiful_arrangement_667().constructArray(3, 1);
        for(int array : arraies)
            System.out.print(array + " ");
    }
}
