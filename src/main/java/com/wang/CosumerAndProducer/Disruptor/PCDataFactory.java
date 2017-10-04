package com.wang.CosumerAndProducer.Disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * Created by ddp on 2017/9/13.
 */
public class PCDataFactory implements EventFactory<PCData> {
    public PCData newInstance() {
        return new PCData();
    }
}
