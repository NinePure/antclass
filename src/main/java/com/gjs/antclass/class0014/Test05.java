package com.gjs.antclass.class0014;

/**
 * Test05
 * 栈溢出
 * @author gujiashun
 * @date 2021/3/8
 */
public class Test05 {

    private static int count;

    public static void count() {
        try {
            count++;
            count();
        } catch (Throwable e) {
            System.out.println("最大深度：");
            System.out.println(count);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        count();
    }
}
