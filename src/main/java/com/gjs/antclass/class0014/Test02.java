package com.gjs.antclass.class0014;

import java.util.ArrayList;

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
        ArrayList<byte[]> bytes = new ArrayList<byte[]>();
        for (int i = 0; i < 20; i++) {
            byte[] b = new byte[1024 * 1024];
            bytes.add(b);
        }
    }
}
