package com.example.fragments;

import java.io.Serializable;

public class Costumers implements Serializable {
    String name;
    int age;

    public Costumers(){

    }

    public Costumers(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
