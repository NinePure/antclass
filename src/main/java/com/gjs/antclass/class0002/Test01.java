package com.gjs.antclass.class0002;

/**
 * Test01
 *
 * @author gujiashun
 * @date 2020/12/28
 */
public class Test01 {

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
            }
        },"thread01").start();
        MyThread myThread = new MyThread("thread02");
        myThread.start();
    }
}

class MyThread extends Thread {

    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-" + i);
        }
    }
}
