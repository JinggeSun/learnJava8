package com.sun.learn.test;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {

        Student student = new Student(1,"jack",20);

        System.out.print(Arrays.asList(student).stream().map(Student::getAge).collect(Collectors.toList()));
    }
}
