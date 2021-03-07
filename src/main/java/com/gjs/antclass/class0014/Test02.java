package com.gjs.antclass.class0014;

/**
 * Test02
 * -Xms20m -Xmx20m -Xmn2m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
 *
 * @author gujiashun
 * @date 2021/3/7
 *
 */
public class Test02 {

    public static void main(String[] args) {
        byte[] b = null;
        for (int i = 0; i < 10; i++) {
            b = new byte[1024 * 1024];
        }
    }
}
