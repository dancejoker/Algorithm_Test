package com.wang.Skip_List;

import java.util.Random;

/**
 * Created by ddp on 2017/8/30.
 */
public class SkipList {
    public SkipListEntry head;
    public SkipListEntry tail;

    public int skipListNum;
    public int skipListHeight;

    public Random r;

    public SkipList() {

       SkipListEntry p1 = new SkipListEntry(SkipListEntry.negInf, null);
       SkipListEntry p2 = new SkipListEntry(SkipListEntry.posInf, null);

       head = p1;
       tail = p2;

       skipListNum = 0;
       skipListHeight = 0;
       r = new Random();
    }

    public int size(){
        return  skipListNum;
    }

    public SkipListEntry findEntry(String key){
        SkipListEntry p ;
        p = head;
        while(true) {
            if (p.next.getKey() != SkipListEntry.posInf && p.next.getKey().compareTo(key) <= 0)
                p = p.next;
            if (p.down != null)
                p = p.down;
            else
                break;
        }
        return p;
    }

    public Integer get(String key){
        SkipListEntry p;
        p = findEntry(key);
        if(key.equals(p.getKey()))
            return p.getValue();
        else
            return null;
    }

    public Integer put(String key,Integer value){
        SkipListEntry priorSkipListEntry, newSkipListEntry;
        int i;
        priorSkipListEntry = findEntry(key);
        if(key.equals(priorSkipListEntry.getKey())){
            Integer old = priorSkipListEntry.getValue();
            priorSkipListEntry.setValue(value);
            return  old;
        }

        newSkipListEntry = new SkipListEntry(key,value);
        newSkipListEntry.prior = priorSkipListEntry;
        newSkipListEntry.next = priorSkipListEntry.next;
        priorSkipListEntry.next.prior = newSkipListEntry;
        priorSkipListEntry.next = newSkipListEntry;


        i = 0; //当前层 leve = 0
        while(r.nextDouble() < 0.5){
            if(i > skipListHeight){
                SkipListEntry p1,p2;
                skipListHeight = skipListHeight + 1;
                p1 = new SkipListEntry(SkipListEntry.negInf, null);
                p2 = new SkipListEntry(SkipListEntry.posInf, null);
                p1.prior = p2;
                p1.down = head;

                p2.prior = p1;
                p2.down = head;
                head.up = p1;
                tail.up = p2;

                head = p1;
                tail = p2;

            }
            while(priorSkipListEntry.up == null){
                priorSkipListEntry = priorSkipListEntry.prior;
            }

            priorSkipListEntry = priorSkipListEntry.up;
            SkipListEntry e = new SkipListEntry(key, null);
            e.prior = priorSkipListEntry;
            e.next = priorSkipListEntry.next;
            e.down = newSkipListEntry;

            priorSkipListEntry.next.prior = e;
            priorSkipListEntry.next = e;

            newSkipListEntry = e;

            i = i + 1;
        }
        skipListHeight += 1;
        return null;
    }

    public Integer remove(String key){
        SkipListEntry priorSkipListEntry,deleteSkipListEntry;
        deleteSkipListEntry = findEntry(key);
        if(deleteSkipListEntry.next.getKey() == SkipListEntry.posInf && deleteSkipListEntry.getKey() != key)
            return null;
        int value = deleteSkipListEntry.getValue();
        while(true){
            priorSkipListEntry =  deleteSkipListEntry.prior;
            priorSkipListEntry.next = deleteSkipListEntry.next;
            deleteSkipListEntry.next.prior = priorSkipListEntry;
            if(priorSkipListEntry.next == null)
                break;
        }
        return value;
    }

}
