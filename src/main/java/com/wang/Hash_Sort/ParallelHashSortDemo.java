package com.wang.Hash_Sort;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ddp on 2017/9/17.
 */
public class ParallelHashSortDemo {
    static ExecutorService pool = Executors.newCachedThreadPool();
    public static class ShellSortTask implements Runnable{
        int i = 0;
        int h = 0;
        CountDownLatch l;
        int[] arr = null;

        public ShellSortTask(int i, int h, CountDownLatch l, int[] arr) {
            this.i = i;
            this.h = h;
            this.l = l;
            this.arr = arr;
        }

        public void run() {
            if(arr[i] < arr[i - h]){
                int tmp = arr[i];
                int j = i - h;
                while(j >=0 && arr[j] > tmp){
                    arr[j + h] = arr[j];
                    j -= h;
                }
                arr[j + h] = tmp;
            }
            l.countDown();
        }
    }

    public static void pShellSort(int[] arr) throws InterruptedException {
        //计算出h的最大值
        int h = 1;
        CountDownLatch latch = null;
        while(h <= arr.length/3){
            h = h * 3;
        }
        while(h > 0){
            System.out.println("h = " + h);
            //控制线程数量
            if(h >= 4)
                latch = new CountDownLatch(arr.length - h);
            for(int i = h; i < arr.length;++i){
                if(h >= 4){
                    pool.execute(new ShellSortTask(i,h,latch,arr));
                }else {
                    if(arr[i] < arr[i - h]){
                        int tmp = arr[i];
                        int j = i - h;
                        while(j >=0 && arr[j] > tmp){
                            arr[j + h] = arr[j];
                            j -=h;
                        }
                        arr[j + h] = tmp;
                    }
                }
            }
            latch.await();
            h = (h - 1)/3;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {6,3,8,2,9,1,10,2,36,20,21,100,29,9,0,12,42,58,18,17,29,30,15,34,255,178,208,41,201,300};
        System.out.println("排序前 : ");
        for(int a : arr)
            System.out.print(a + " ");
        System.out.println();
        pShellSort(arr);
        System.out.println("排序后 : ");
        for(int a : arr)
            System.out.print(a + " ");
        pool.shutdown();
        System.out.println();
    }
}
