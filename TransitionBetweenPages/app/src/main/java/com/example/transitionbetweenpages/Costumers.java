package com.example.transitionbetweenpages;

import java.io.Serializable;

public class Costumers implements Serializable {
    String name ;
    int age ;

    public Costumers(){

    }
    public Costumers(String name, int age){
        this.name = name;
        this.age = age;
    }


}

