package com.gjs.antclass.class0014;

/**
 * Test01
 *
 * @author gujiashun
 * @date 2021/3/7
 */
public class Test01 {

    public static void main(String[] args) {
        byte[] bytes = new byte[12 * 1024 * 1024];
        System.out.println("分配4M给数组");

        System.out.println("最大内存" + Runtime.getRuntime().maxMemory()/1024/1024 +"M");
        System.out.println("可用内存" + Runtime.getRuntime().freeMemory()/1024/1024 +"M");
        System.out.println("已使用内存" + Runtime.getRuntime().totalMemory()/1024/1024 +"M");

    }
}
