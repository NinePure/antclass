package com.gjs.antclass.class0007;

import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * Test03
 *
 * @author gujiashun
 * @date 2021/2/22
 */
public class Test03 {
    volatile HashMap<String, String> cache = Maps.newHashMap();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    WriteLock writeLock = lock.writeLock();
    ReadLock readLock = lock.readLock();


    public void put(String key, String value) {
        try {
            writeLock.lock();
            System.out.println("写入元素key：" + key + "，value：" + value + "写入开始");
            Thread.sleep(500L);
            cache.put(key, value);
            System.out.println("写入元素key：" + key + "，value：" + value + "写入结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public String get(String key) {
        String value = null;
        try {
            readLock.lock();
            System.out.println("读取元素key：" + key + "读取开始");
            Thread.sleep(500L);
            value = cache.get(key);
            System.out.println("读取元素key：" + key + "，value：" + value + "读取结束");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return value;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                test03.put(i+"", "value" + i);
            }
        },"input thread name").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                String value = test03.get(i+"");
                System.out.println("获得结果" + value);
            }
        },"input thread name").start();
    }

}
