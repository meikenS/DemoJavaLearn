package com.reflectdemo;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author gaoran
 * @version 1.0
 * @since 1.5
 */
@SuppressWarnings("all")
public class ReflectTest1 {
    public static void main(String[] args) throws Exception {
        /*Class cls = Class.forName("com.model.Person");
        Object person = cls.newInstance();
        String classname = cls.getName();
        Method method1 = cls.getMethod("eat",String.class);
        method1.invoke(person, "apple");*/
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectTest1.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.proporties");
        properties.load(is);
        String className = properties.getProperty("ClassName");
        String methodName = properties.getProperty("MethodName");
        Class<?> aClass = Class.forName(className);
        Method[] declaredMethods = aClass.getMethods();
        for (Method method : declaredMethods)
            System.out.println(method);
        Object obj = aClass.newInstance();
        Method method = aClass.getDeclaredMethod(methodName, String.class);
        method.setAccessible(true);
        method.invoke(obj, "8:00");
        System.out.println(className);
        Constructor<?> constructor = aClass.getConstructor(String.class, int.class);
        Object gaoran = constructor.newInstance("gaoran", 25);
        System.out.println(gaoran);
    }
    /**
     * @param a
     * @param b
     * @return a,b的和
     * */
    public int add(int a, int b) {
        return a + b;
    }
}
