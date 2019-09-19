package com.sun.learn;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        distict(Arrays.asList("Hello","Word"));

        upper(Arrays.asList("Hello","Word"));

        fliterTest(Arrays.asList(1,2,3,4,5));

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

    /**
     * 将列表里的字符串 化为字符后去重
     * @param list
     */
    public static void distict(List<String> list){
         list.stream().map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).distinct().forEach(str-> System.out.printf(str));
    }

    public static int sum(List<Integer> list){
        return list.stream().reduce(0, Integer::sum);
    }

    /**
     * 转换大写
     * @param list
     */
    public static void upper(List<String> list){
        System.out.print(list.stream().map(String::toUpperCase).collect(Collectors.joining()));
    }


    /**
     * flatmap 多对1映射
     */
    public static void trans(){

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        //1. Stream<List<Integer>>
        Stream<List<Integer>> streamList = Stream.of(list1,list2,list3);
        //2. Stream<Integer>
        Stream<Integer> streamInteger = streamList.flatMap(Collection::stream);

    }

    static void fliterTest(List<Integer> list){
        List v = list.stream().filter(intVal -> intVal % 2 == 0).collect(Collectors.toList());
        System.out.print(String.valueOf(v));
    }


}
