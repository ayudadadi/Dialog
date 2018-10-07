package com.ayu.ayu;

public class Student {
    public int getImgid() {
        return imgid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private int imgid;
    private String name;
    private int age;
    public Student(int imgid,String name,int age){
        this.imgid =imgid;
        this.name = name;
        this.age = age;
    }
}
