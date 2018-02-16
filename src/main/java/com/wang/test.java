package com.wang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Created by ddp on 2018/1/10.
 */
public class test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        new test().add(list);
        for(String i : list)
            System.out.println(i);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = o2.compareTo(o1);
                System.out.println(i);
                return i;
            }
        });
        for(String i : list)
            System.out.println(i);

        List<String> list1 = list.subList(0, 2);

        for(String i : list1)
            System.out.println(i);
    }
    public void add(List<String> hello){
        hello.add("c");
        hello.add("d");
    }
}
