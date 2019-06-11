package com.reflectdemo;

public class Caculator {
    int a = 0;
    int b = 1;

    @Check
    public void add() {
        int c = a + b;
    }

    @Check
    public void div(){
        int c =b / a;
    }
}
