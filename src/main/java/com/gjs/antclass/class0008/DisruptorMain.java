package com.gjs.antclass.class0008;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * DisruptorMain
 *
 * @author gujiashun
 * @date 2021/2/23
 */
public class DisruptorMain {
    AtomicInteger num = new AtomicInteger(0);
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();
        ExecutorService executor = new ThreadPoolExecutor(2, 3,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        EventFactory<LongEvent> myEventFactory = new MyEventFactory();
        int ringBufferSize = 1024 * 1024; // ringBufferSize大小一定要是2的N次方
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(myEventFactory, ringBufferSize, executor, ProducerType.SINGLE,
                new YieldingWaitStrategy());
        disruptor.handleEventsWith(new MyEventHandle());
        disruptor.handleEventsWith(new MyEventHandle());
        disruptor.handleEventsWith(new MyEventHandle());
        disruptor.handleEventsWith(new MyEventHandle());
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        MyEventProducer myEventProducer = new MyEventProducer(ringBuffer);
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
        DisruptorMain disruptorMain = new DisruptorMain();
        for (int i = 0; i < 100; i++) {
            byteBuffer.putLong(0, disruptorMain.num.getAndIncrement());
            myEventProducer.onData(byteBuffer);
        }
        disruptor.shutdown();
        executor.shutdown();
    }


}
