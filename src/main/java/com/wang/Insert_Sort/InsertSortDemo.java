package com.wang.Insert_Sort;

/**
 * Created by ddp on 2017/9/17.
 */
public class InsertSortDemo {
    public static void insertSort(int[] arr){
        int len = arr.length;
        int i,j,key;
        for(i = 1 ; i < len; ++i){
            //Key为要准备插入的元素
            key = arr[i];
            j = i - 1;
            while(j >=0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,3,8,2,9,1};

        System.out.println("排序前 : ");
        for(int a : arr)
            System.out.print(a + " ");
        System.out.println();
        insertSort(arr);
        System.out.println("排序后 : ");
        for(int a : arr)
            System.out.print(a + " ");
        System.out.println();
    }
}
