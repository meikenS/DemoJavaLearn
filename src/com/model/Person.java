package com.model;

public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String name;
    private String password;
    public Person() {
    }
    public Person(String name, String password){
        this.name = name;
        this.password = password;
    }

    public void eat(String thing){
        System.out.println("eat.."+thing);
    }
}
