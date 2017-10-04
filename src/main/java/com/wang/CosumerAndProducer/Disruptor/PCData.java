package com.wang.CosumerAndProducer.Disruptor;

/**
 * Created by ddp on 2017/9/13.
 */
public class PCData {
    private long value;
    public void set(long value){
        this.value = value;
    }
    public long get(){
        return  value;
    }
}
