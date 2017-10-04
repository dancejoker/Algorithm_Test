package com.wang.Hash_Sort;

/**
 * Created by ddp on 2017/9/17.
 */
public class HashSortDemo {
    public static void shellSort(int[] arr){
        int h = 1;
        while(h <= arr.length / 3){
            h = h * 3 + 1;
        }
        while(h > 0){
            for(int i = h;i < arr.length; ++i){
                if(arr[i] < arr[i - h]){
                    int tmp = arr[i];
                    int j = i - h;
                    while(j >= 0 && arr[j] > tmp){
                        arr[j + h] = arr[j];
                        j -= h;
                    }
                    arr[j + h] = tmp;
                }
            }
            h = (h - 1)/3;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,3,8,2,9,1};
        System.out.println("排序前 : ");
        for(int a : arr)
            System.out.print(a + " ");
        System.out.println();
        shellSort(arr);
        System.out.println("排序后 : ");
        for(int a : arr)
            System.out.print(a + " ");
        System.out.println();
    }
}
