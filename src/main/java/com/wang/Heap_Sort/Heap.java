package com.wang.Heap_Sort;

import java.util.ArrayList;

/**
 * Created by ddp on 2018/2/20.
 */
public class Heap {
    private ArrayList<Integer> list;

    private int heapSize;

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }
}
