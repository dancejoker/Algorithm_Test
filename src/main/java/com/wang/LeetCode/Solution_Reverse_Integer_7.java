package com.wang.LeetCode;

/**
 * Created by ddp on 2017/12/27.
 */
public class Solution_Reverse_Integer_7 {
    public int reverse(int x) {
        char[] s = String.valueOf(x).toCharArray();
        int end = s.length - 1;
        for(int i = 0;i < s.length ; ++i){
            if(s[i] == '-'){
                continue;
            }else {
                if(i < end){
                    char endword = s[end];
                    char beginword = s[i];
                    s[end] = beginword;
                    s[i] = endword;
                    --end;
                }
            }
        }
        long num = Long.parseLong(new String(s));
        if(num>Integer.MAX_VALUE||num<Integer.MIN_VALUE) return 0;
        return (int)num;
    }

    public int reverse2(int x){
        long result = 0;
        //long type is for compare. Only larger range can compare Max and Min Integer

        while(x!=0) {
            int mod = x%10;
            x = x/10;
            result = result*10 + mod;
            if(result>Integer.MAX_VALUE||result<Integer.MIN_VALUE) return 0;
        }
        return (int) result;
    }
    public static void main(String[] args) {
        Solution_Reverse_Integer_7 rev = new Solution_Reverse_Integer_7();
        System.out.println(rev.reverse2(1000));
    }
}
