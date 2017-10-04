package com.wang.CosumerAndProducer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ddp on 2017/9/12.
 */
public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;
    private static AtomicInteger count = new AtomicInteger(); //总数，原子操作
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }
    public void run() {
        PCData data = null;
        Random r = new Random();
        System.out.println("start producer id" + Thread.currentThread().getId());
        try {
                while(isRunning) {
                    Thread.sleep(r.nextInt(SLEEPTIME));
                    data = new PCData(count.incrementAndGet());
                    System.out.println(data + " is put into queue");
                    if(!queue.offer(data,2, TimeUnit.SECONDS)){
                        System.err.println("failed to put data" + data);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
    }
    public void stop(){
        isRunning = false;
    }
}
