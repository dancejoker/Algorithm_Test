package com.wang.Sword_To_Offer;

/**
 * 数值的整数次方
 * Created by ddp on 2018/2/22.
 */
public class Question_11 {
    public static void main(String[] args) throws Exception {
        Question_11 p11 = new Question_11();
        System.out.println(p11.power(2.0, 3));
    }
    public double power(double base,int exponent) throws Exception {
        double result = 0.0;
        if(equal(base,0.0) && exponent < 0) {
            throw new Exception("0的负数次幂没有意义");
        }
        if(exponent < 0) {
            result=1.0 / powerWithExpoment(base,-exponent);
        } else{
//            result=powerWithExpoment(base, exponent);
            result = powerWithOptimizeExpoment(base, exponent);
        }
        return result;
    }
    private double powerWithExpoment(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base;
        }
        double result = 1.0;
        for(int i=1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }
    //优化后算法
    private double powerWithOptimizeExpoment(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base;
        }
        double result = powerWithOptimizeExpoment(base,exponent >> 1);
        result *= result;
        if((exponent & 0x1) == 1)
            result *= base;
        return result;
    }
    private boolean equal(double num1, double num2) {
        if((num1 - num2 > -0.0000001) && num1 - num2 < 0.0000001) {
            return true;
        } else {
            return false;
        }
    }
}
