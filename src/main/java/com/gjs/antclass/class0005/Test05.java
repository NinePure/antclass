package com.gjs.antclass.class0005;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;

/**
 * Test05
 *
 * @author gujiashun
 * @date 2021/2/1
 */
public class Test05 {

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(6);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, queue,
                namedThreadFactory);
        ArrayList<Future<?>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final int a = i;
            Future<?> submit = threadPoolExecutor.submit(() -> {
                Thread.sleep(1000L);
                System.out.println("子线程输出" + a + Thread.currentThread().getName());
                return a + Thread.currentThread().getName();
            });
            futureList.add(submit);
        }
        try {
            for (Future<?> future : futureList) {
                System.out.println(future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }

    }

}
