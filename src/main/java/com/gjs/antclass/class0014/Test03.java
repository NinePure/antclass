package com.gjs.antclass.class0014;

import java.util.ArrayList;

/**
 * Test03
 * -Xms20m -Xmx20m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
 * @author gujiashun
 * @date 2021/3/8
 */
public class Test03 {
    public static void main(String[] args) {
        ArrayList<byte[]> bytes = new ArrayList<byte[]>();
        for (int i = 0; i < 20; i++) {
            byte[] b = new byte[1024 * 1024];
            bytes.add(b);
        }
    }
}
