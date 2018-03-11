package com.wang.Heap_Sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ddp on 2018/2/20.
 */
public class HeapSort {
    // 左节点下标
    public int left(int i) {
        return i * 2 + 1;
    }

    // 右节点下标
    public int right(int i) {
        return i * 2 + 2;
    }

    // 父节点下标
    public int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * 递归实现的堆排序
     * @param heap 堆
     * @param i 当前坐标
     */
    public void RecusiveHeapAdjust(Heap heap, int i){
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l < heap.getHeapSize() && heap.getList().get(l) > heap.getList().get(i)){
            largest = l;
        }
        if(r < heap.getHeapSize() && heap.getList().get(r) > heap.getList().get(largest)){
            largest = r;
        }
        if(largest != i){
            int temp = heap.getList().get(i);
            heap.getList().set(i,heap.getList().get(largest));
            heap.getList().set(largest,temp);
        } else
            return;
        RecusiveHeapAdjust(heap, largest);
    }

    /**
     * 非递归实现的堆排序
     * @param heap 堆
     * @param i 当前坐标
     */
    public void NoRecusiveHeapAdjust(Heap heap, int i){
        while (true){
            int l = left(i);
            int r = right(i);
            int heapSize = heap.getHeapSize();
            ArrayList<Integer> list = heap.getList();
            int largest = i;
            if (l < heapSize && list.get(l) > list.get(i)) {
                largest = l;
            }
            if (r < heapSize && list.get(r) > list.get(largest)) {
                largest = r;
            }
            if (largest != i) {
                int temp = list.get(i);
                list.set(i, list.get(largest));
                list.set(largest, temp);
            } else
                return;
            i = largest;
        }
    }

    /**
     * 构建最大堆
     * @param heap 堆
     */
    public void BuildMaxHeap(Heap heap) {
        int heapsize = heap.getHeapSize();
        for (int i = (heapsize - 1) / 2; i >= 0; i--) {
//            RecusiveHeapAdjust(heap, i);
            NoRecusiveHeapAdjust(heap, i);
        }
    }

    public void heapSort(Heap heap){
        BuildMaxHeap(heap);
        int length = heap.getList().size(), heapSize = heap.getHeapSize();
        for (int i = length - 1; i > 0; i--) {
            int temp = heap.getList().get(i);
            heap.getList().set(i, heap.getList().get(0));
            heap.getList().set(0,temp);
            heap.setHeapSize(--heapSize);
 //           RecusiveHeapAdjust(heap, 0);
            NoRecusiveHeapAdjust(heap, 0);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(1,10,5,9,20,19,25));

        Heap heap = new Heap();
        heap.setList(list);
        heap.setHeapSize(list.size());
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(heap);
        System.out.println(heap.getList().toString());
        System.out.println(heap.getHeapSize());
    }
}
