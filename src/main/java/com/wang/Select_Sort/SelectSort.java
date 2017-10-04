package com.wang.Select_Sort;

/**
 * Created by Administrator on 2017/5/3 0003.
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {6,3,8,2,9,1};
        System.out.println("排序前数组为：");
        for(int num:arr){
            System.out.print(num + " ");
        }
        //优化的选择排序
        for(int i = 0 ; i < arr.length; ++i){
            int min = i;
            for(int j = min+1; j < arr.length ; ++j){
                if (arr[j] < arr[min]) min = j;
            }
            if(i != min){
               arr[i] = arr[i] + arr[min];
               arr[min] = arr[i] - arr[min];
               arr[i] = arr[i] - arr[min];
            }
        }
        System.out.println();
        System.out.println("排序后的数组为：");
        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
