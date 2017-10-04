package com.wang.CosumerAndProducer;

/**
 * Created by ddp on 2017/9/12.
 */
public final class PCData {
    private final int intData;
    public PCData(int d) {
        intData = d;
    }

    public PCData(String d){
        intData = Integer.valueOf(d);
    }
    public int getData(){
        return  intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;
    }
}
