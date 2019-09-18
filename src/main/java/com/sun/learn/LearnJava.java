package com.sun.learn;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class LearnJava {

    public static void main(String[] args) {
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        Map<String,Object> map3 = new HashMap<>();
        map1.put("hot",430);
        map1.put("name","d");
        map2.put("hot",200);
        map2.put("name","b");
        map3.put("hot",300);
        map3.put("name","c");
        List<Map<String,Object>> list = Arrays.asList(map1,map2,map3);
        System.out.print(getName(list).toString());
    }


    /**
     * 取热量小于400，并按卡路里排序
     *
     * @param list
     * @return
     */
    public static List<String> getName(List<Map<String, Object>> list) {

        return list.stream().filter(map -> (Integer) map.get("hot") < 400).sorted(Comparator.comparing(map -> (Integer) map.get("hot"))).map(map -> map.get("name").toString()).collect(toList());

    }

}
