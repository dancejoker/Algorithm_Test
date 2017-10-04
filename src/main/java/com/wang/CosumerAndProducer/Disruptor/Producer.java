package com.wang.CosumerAndProducer.Disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * Created by ddp on 2017/9/13.
 */
public class Producer {
    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb){
        long sequeue = ringBuffer.next();
        try {
            PCData event = ringBuffer.get(sequeue);
            event.set(bb.getLong(0));
        } finally {
            ringBuffer.publish(sequeue);
        }
    }
}
