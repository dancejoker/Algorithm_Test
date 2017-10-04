package com.wang.Quick_Sort;

/**
 * Created by Administrator on 2017/5/8 0008.
 */
public class Quick_Sort_Optimize1 {

    public static int Partition(int[] arr,int low, int high) {
        if(arr == null || low < 0 || high >= arr.length){
            new Exception();
        }
        int pivotkey;
        ChoosePivotkey(arr,low,high);//选取枢轴值
        pivotkey = arr[low];
        while(low < high) {
            while (low < high && arr[high] >= pivotkey)
                high--;
            Swap(arr, low, high);//交换
            while (low < high && arr[low] < pivotkey) //如果小于枢轴值，则下标加一，否则，跳出循环。
                low++;
            Swap(arr, low, high);//交换
        }
        return low;
    }

    public static void ChoosePivotkey(int[] arr,int low,int high) {
            int mid = low + (int)(high - low)/2;
        if(arr[low] > arr[high])//保证左端较小
            Swap(arr, low, high);
        if(arr[mid] > arr[high])//保证中间较小
            Swap(arr, mid, high);
        //此时最大值在最右边
        if(arr[mid] > arr[low])//保证中间较小
            Swap(arr, mid, low);
    }

    public static void Swap(int[] arr,int low,int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
    public static void QSort(int[] arr,int low,int high) {
        int pivot;
        if(low < high) {
            pivot = Partition(arr,low,high);
            QSort(arr,low,pivot - 1);
            QSort(arr,pivot + 1,high);
        }
    }
    public static void  QuickSort(int[] arr) {
        QSort(arr,0,arr.length - 1);
    }
    public static void main(String[] args) {
        int[] arr = {50,10,90,30,70,40,80,60,20};
        QuickSort(arr);
        for (int array : arr) {
            System.out.print(array+" ");
        }
        System.out.println();
    }
}
