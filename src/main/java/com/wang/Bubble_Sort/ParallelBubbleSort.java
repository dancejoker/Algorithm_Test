package com.wang.Bubble_Sort;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ddp on 2017/9/17.
 */
public class ParallelBubbleSort {
    //exchFlag用来记录当前迭代是否发生了数据交换
    static int exchFlag = 1;
    static ExecutorService pool = Executors.newCachedThreadPool();

    static synchronized void setExchFlag(int v) {
        exchFlag = v;
    }

    public static int getExchFlag() {
        return exchFlag;
    }
    public static class OddEvenSortTask implements Runnable{
        int i;
        CountDownLatch latch;
        int[] arr ;

        public OddEvenSortTask(int i, CountDownLatch latch, int[] arr) {
            this.i = i;
            this.latch = latch;
            this.arr = arr;
        }
        public void run() {
            if(arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                setExchFlag(1);
            }
            latch.countDown();
        }
    }
    public static void pOddEvenSort(int[] arr) throws InterruptedException {
        //start变量用来记录是奇交换还是偶交换
        int start = 0;
        while(getExchFlag() == 1 || start == 1){
            setExchFlag(0);
            //偶数的数组长度，当start == 1时，只有len/2-1个线程
            CountDownLatch latch = new CountDownLatch(arr.length / 2 - (arr.length % 2 == 0 ? start : 0));
            for(int i = start; i < arr.length -1 ;i += 2){
                pool.submit(new OddEvenSortTask(i,latch,arr));
            }
            latch.await();
            if(start == 0)
                start = 1;
            else
                start = 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {6,3,8,2,9,1,10,2,36,20,21};
        System.out.println("排序前 : ");
        for(int a : arr)
            System.out.print(a + " ");
        System.out.println();
        pOddEvenSort(arr);
        System.out.println("排序后 : ");
        for(int a : arr)
            System.out.print(a + " ");
        pool.shutdown();
        System.out.println();

    }

}
