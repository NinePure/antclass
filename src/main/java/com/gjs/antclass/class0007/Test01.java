package com.gjs.antclass.class0007;

/**
 * Test01
 *
 * @author gujiashun
 * @date 2021/2/11
 */
public class Test01 implements Runnable {

    String name;

    @Override
    public void run() {
        set();
    }

    public synchronized void set() {
        System.out.println("set");
        get();
    }

    public synchronized void get() {
        System.out.println("进入get");
    }
}
