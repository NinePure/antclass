package com.gjs.antclass.class0004;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * test01
 *
 * @author gujiashun
 * @date 2021/1/25
 */
public class Test01 {
    public static void main(String[] args) {
        Res0401 res = new Res0401();
        Condition condition = res.lock.newCondition();
        new IntThread0401(res, condition).start();
        new OutThread0401(res, condition).start();
    }
}

class Res0401
{
    String name;
    String sex;
    boolean flag = true;
    Lock lock = new ReentrantLock();
}

class IntThread0401 extends Thread {

    Res0401 res;
    Condition condition;

    public IntThread0401(Res0401 res, Condition condition) {
        this.res = res;
        this.condition = condition;
    }

    @Override
    public void run() {
        int count = 0;
        Lock lock = res.lock;
        while (true) {
            lock.lock();
            try {
                if (!res.flag) {
                    condition.await();
                }
                if (count == 0) {
                    res.name = "小军";
                    res.sex = "男";
                } else {
                    res.name = "小红";
                    res.sex = "女";
                }
                count = (count + 1) % 2;
                res.flag = false;
                condition.signal();
            } catch (Exception e) {
            }finally {
                lock.unlock();
            }
        }
    }
}

class OutThread0401 extends Thread {

    Res0401 res;
    Condition condition;

    public OutThread0401(Res0401 res, Condition condition) {
        this.res = res;
        this.condition = condition;
    }

    @Override
    public void run() {
        Lock lock = res.lock;
        while (true) {
            lock.lock();
            try {
                if (res.flag) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("姓名:" + res.name + ";性别:" + res.sex);
                res.flag = true;
                condition.signal();
            } catch (Exception e) {

            }finally {
                lock.unlock();
            }

        }
    }
}

