package com.reflectdemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

public class AnnoTest {
    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("com.reflectdemo.Caculator");
        Object caculator = aClass.newInstance();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        int count = 0;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bug.txt"));
        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.invoke(caculator);
                } catch (Exception e){
                    count++;
                    bufferedWriter.write(method.getName()+"出现异常");
                    bufferedWriter.newLine();
                    bufferedWriter.write("异常类型："+e.getCause().getMessage());
                    bufferedWriter.newLine();
                    bufferedWriter.write("这是第"+count+"个异常");
                    bufferedWriter.newLine();
                }

            }
        }
        bufferedWriter.write("总共异常数："+count);
        bufferedWriter.close();
    }
}
