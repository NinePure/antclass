package com.gjs.antclass.class0005;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Test01
 *
 * @author gujiashun
 * @date 2021/1/25
 */
public class Test01 {

    public static void main(String[] args) {
//        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
//        new ThreadInput(queue).start();
//        new ThreadOut(queue).start();
//        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
        try {
            queue.offer("1");// 非阻塞式
            queue.offer("2", 3, TimeUnit.SECONDS);// 阻塞式
            queue.offer("3", 3, TimeUnit.SECONDS);// 阻塞式
            System.out.println(queue.poll(3, TimeUnit.SECONDS));// 阻塞式
            System.out.println(queue.poll());
            System.out.println(queue.poll(3, TimeUnit.SECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

class ThreadInput extends Thread {

    ArrayBlockingQueue<String> queue;

    public ThreadInput(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                System.out.println("添加队列" + count);
                queue.put("" + count);
                System.out.println("添加队列完成" + count);
                sleep(1000L);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class ThreadOut extends Thread {

    ArrayBlockingQueue<String> queue;

    public ThreadOut(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("开始获取");
                System.out.println(queue.take());
                System.out.println("完成获取");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

