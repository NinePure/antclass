package com.gjs.antclass.class0007;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;

/**
 * Test04 乐观锁
 *
 * @author gujiashun
 * @date 2021/2/22
 */
public class Test04 {

    private volatile AtomicInteger atomicInteger = new AtomicInteger();
    private volatile Integer count;

    public static void main(String[] args) {
        Test04 test04 = new Test04();
    }
}
