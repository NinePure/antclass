package com.gjs.antclass.class0005;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Test02 并发队列实现生产者消费者
 *
 * @author gujiashun
 * @date 2021/1/25
 */
public class Test02 {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(1);
        ProducerThread producerThread = new ProducerThread(queue);
        new Thread(producerThread).start();
        new Thread(new ConsumerThread(queue)).start();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        producerThread.stop();
    }

}

class ProducerThread implements Runnable {

    BlockingQueue<String> queue;
    volatile Boolean flag = true;
    public ProducerThread(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 0;
        System.out.println("开始生产");
        while (flag) {
            try {
                System.out.println("生产数据" + count);
                queue.offer(count + "", 2, TimeUnit.SECONDS);
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
        }
        System.out.println("生产结束");
    }

    public void stop() {
        this.flag = false;
    }
}

class ConsumerThread implements Runnable {
    BlockingQueue<String> queue;
    volatile Boolean flag = true;
    public ConsumerThread(BlockingQueue<String> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        System.out.println("开始消费");
        try {
            while (flag) {
                try {
                    String data = queue.poll(2, TimeUnit.SECONDS);
                    if (data == null) {
                        System.out.println("2s未读取到数据");
                        flag = false;
                        return;
                    }
                    System.out.println("消费者获取到数据" + data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }finally {
            System.out.println("消费者结束");
        }

    }
}
