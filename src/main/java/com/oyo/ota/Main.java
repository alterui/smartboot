package com.oyo.ota;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * @author liurui
 * @date 2019/9/12 16:15
 */
public class Main {
    public static void main(String[] args) {
       /* String str = "2019-07-07~2019-07-08";
        String[] splits = str.split("~");
        for (String split : splits) {
            System.out.println();
        }*/

        Multimap<String, String> map = ArrayListMultimap.create();

       // Map<String, String> map = new IdentityHashMap<String, String>();
        map.put("1", "2");
        map.put("1", "3");

        map.put("2", "3");
       /* //System.out.println(map.entrySet().);
        for (Map.Entry<String, String> entry : map.) {
            System.out.println(entry.getValue());
        }*/

        for (String value : map.values()) {
            //System.out.println(value);
        }

        for (String key : map.keys()) {
            System.out.println(map.get(key));
        }


    }


}
