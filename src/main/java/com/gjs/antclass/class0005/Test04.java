package com.gjs.antclass.class0005;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Test04 线程池
 * 降低资源消耗，提高效率，方便管理
 *
 * @author gujiashun
 * @date 2021/1/26
 */
public class Test04 {

    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);
        Executors.newScheduledThreadPool(3);
        Executors.newSingleThreadExecutor();

    }
}
