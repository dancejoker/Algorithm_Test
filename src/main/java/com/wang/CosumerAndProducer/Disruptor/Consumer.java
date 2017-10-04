package com.wang.CosumerAndProducer.Disruptor;

import com.lmax.disruptor.WorkHandler;

/**
 * Created by ddp on 2017/9/13.
 */
public class Consumer implements WorkHandler<PCData> {
    public void onEvent(PCData event) throws Exception {
        System.out.println(Thread.currentThread().getId() + ": Event: --" + event.get() * event.get() + "--");
    }
}
