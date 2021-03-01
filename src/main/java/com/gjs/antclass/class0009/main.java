package com.gjs.antclass.class0009;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * main
 *
 * @author gujiashun
 * @date 2021/2/25
 */
public class main {
    public static void main(String[] args) {
        try {
            Class<?> testC = Class.forName("com.gjs.antclass.class0009.Test01");
            Test01 test = (Test01) testC.getDeclaredConstructor(String.class,Integer.class).newInstance("345",222);
//            Test01 test2 = (Test01) testC.getDeclaredConstructor(int.class,String.class).newInstance(222,"345");
//            System.out.println(test);
//            System.out.println(test2);
//            for (Method method : testC.getMethods()) {
//                System.out.println(method.getName());
//            }
            for (Field field : testC.getDeclaredFields()) {
                System.out.println(field.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
