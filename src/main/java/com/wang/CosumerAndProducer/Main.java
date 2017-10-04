package com.wang.CosumerAndProducer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ddp on 2017/9/13.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<PCData> queue = new LinkedBlockingQueue<PCData>(10);
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Cosumer cosumer1 = new Cosumer(queue);
        Cosumer cosumer2 = new Cosumer(queue);
        Cosumer cosumer3 = new Cosumer(queue);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(cosumer1);
        service.execute(cosumer2);
        service.execute(cosumer3);
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();
        Thread.sleep(3000);
        service.shutdown();
    }
}
