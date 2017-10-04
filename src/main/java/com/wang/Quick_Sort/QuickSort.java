package com.wang.Quick_Sort;

/**
 * Created by Administrator on 2017/5/4 0004.
 */
public class QuickSort {
    //选择一个关键字，想尽办法将它放到一个位置，使得它左边的值都比它小，
    //右边的值都比它大，我们称这个关键字叫枢轴。
    public static int Partition(int[] arr,int low,int high){
        if(arr == null || low < 0 || high >= arr.length){
            new Exception();
        }
        int pivotkey;
//        pivotkey = arr[low];//选取第一个记录作枢轴记录
//        while(low < high){
//            while(low < high && arr[high] >= pivotkey)  //如果大于枢轴值，则下标减一，否则，跳出循环
//                --high;
//            Swap(arr,low,high);
//            while(low < high && arr[low] < pivotkey)    //如果小于枢轴值，则下标加一，否则，跳出循环。
//                ++low;
//            Swap(arr,low,high);
//        }
        pivotkey = arr[high];
        while(low < high){
            while(low < high && arr[low] <= pivotkey)
                ++ low;
            Swap(arr,low,high);
            while(low < high && arr[high] > pivotkey)
                -- high;
            Swap(arr,low,high);
        }
        return high;
    }
    public static void Swap(int[] arr,int low,int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    //对顺序表子序列作快速排序     待排序序列的最小下标值low和最大下标值high
    public static void QSort(int[] arr,int low,int high){
        int pivot;
        if(low < high){
            pivot = Partition(arr,low,high);
            QSort(arr,low,pivot - 1);
            QSort(arr,pivot + 1,high);
        }
    }
    public static void Quick_Sort(int[] arr){
        QSort(arr,0,arr.length - 1);
    }
    public static void main(String[] args) {
        int[] arr = {50,10,90,30,70,40,80,60,20};
        Quick_Sort(arr);
        for(int array :arr){
            System.out.print(array + " ");
        }
        System.out.println();
    }
}
