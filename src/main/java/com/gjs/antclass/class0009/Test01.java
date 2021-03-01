package com.gjs.antclass.class0009;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Test01
 *
 * @author gujiashun
 * @date 2021/2/25
 */
public class Test01 {

    private String name;
    private int age;

    private Test01(String name,Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("111构造test01");
    }
    private Test01(int age,String name) {
        this.name = name;
        this.age = age;
        System.out.println("222构造test01");
    }

    @Override
    public String toString() {
        return "Test01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        try {
            Class<?> testC = Class.forName("com.gjs.antclass.class0009.Test01");
            Test01 test = (Test01) testC.getDeclaredConstructor(String.class,Integer.class).newInstance("345",222);
            Test01 test3 = (Test01) testC.getConstructor(String.class,Integer.class).newInstance("345",222);
            Test01 test2 = (Test01) testC.getDeclaredConstructor(int.class,String.class).newInstance(222,"345");
            System.out.println(test);
            System.out.println(test2);
            for (Method method : testC.getMethods()) {
                System.out.println(method.getName());
            }
            for (Field field : testC.getDeclaredFields()) {
                System.out.println(field.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
