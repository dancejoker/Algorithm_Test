package com.wang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * Created by ddp on 2018/1/10.
 */
public class test {
    public static void main(String[] args) {
        String str2 = new String("str")+new String("01");
        String str1 = "str01";
        str2.intern();
        System.out.println(str2.intern()==str1);
    }
}
