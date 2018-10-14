package com.example.yls.demoa;

/**
 * Created by yls on 2018/10/8.
 */

public class Student {
    private String name;
    private int age;
    private int imgId;

    public Student(String name, int age, int imgId){
        this.age = age;
        this.name = name;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getImgId() {
        return imgId;
    }
}
