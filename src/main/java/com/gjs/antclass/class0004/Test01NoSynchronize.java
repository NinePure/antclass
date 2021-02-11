package com.gjs.antclass.class0004;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * test01
 *
 * @author gujiashun
 * @date 2021/1/25
 */
public class Test01NoSynchronize {
    public static void main(String[] args) {
        Res040102 res = new Res040102();
        new IntThread040102(res).start();
        new OutThread040102(res).start();
    }
}

class Res040102 {
    String name;
    String sex;
    volatile AtomicBoolean flag = new AtomicBoolean(true);
}

class IntThread040102 extends Thread {

    Res040102 res;

    public IntThread040102(Res040102 res) {
        this.res = res;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            if (res.flag.get()) {
                if (count == 0) {
                    res.name = "小军";
                    res.sex = "男";
                } else {
                    res.name = "小红";
                    res.sex = "女";
                }
                count = (count + 1) % 2;
                res.flag.compareAndSet(true, false);
            }
        }
    }
}

class OutThread040102 extends Thread {

    Res040102 res;

    public OutThread040102(Res040102 res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            if (!res.flag.get()) {
                System.out.println("姓名:" + res.name + ";性别:" + res.sex);
                res.flag.compareAndSet(false, true);
            }
        }
    }
}

