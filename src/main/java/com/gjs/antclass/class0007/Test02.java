package com.gjs.antclass.class0007;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Test02
 *
 * @author gujiashun
 * @date 2021/2/11
 */
public class Test02 extends Thread {

    Lock lock = new ReentrantLock();


    @Override
    public void run() {
        set();
    }

    public void set() {
        try {
            lock.lock();
            System.out.println("set");

            get();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            System.out.println("进入get");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
