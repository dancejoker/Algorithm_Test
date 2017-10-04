package com.wang.Skip_List;

/**
 * Created by ddp on 2017/8/30.
 */
public class SkipListEntry {
    public String key;
    public int value;
    public int pos;
    public SkipListEntry next,prior,up,down;

    public static String negInf = new String("-oo"); // 负无穷
    public static String posInf = new String("+oo"); // 正无穷

    public SkipListEntry(String key, Integer value) {
        this.key = key;
        this.value = value;
        next = prior = up = down = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        SkipListEntry skipListEntry ;
        try {
            skipListEntry = (SkipListEntry)obj;
        } catch (ClassCastException ex){
            return  false;
        }
        return  (skipListEntry.getKey() == key) && (skipListEntry.getValue() == value);
    }

    @Override
    public String toString() {
        return "SkipListEntry{" +
                "key='" + key + '\'' +
                ", value=" + value +
                '}';
    }
}
