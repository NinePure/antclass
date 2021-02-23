package com.gjs.antclass.class0008;

import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;

/**
 * MyEventProducer
 *
 * @author gujiashun
 * @date 2021/2/23
 */
public class MyEventProducer {

    public final RingBuffer<LongEvent> ringBuffer;

    public MyEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer) {
        long sequence = ringBuffer.next();
        Long data = null;
        try {
            LongEvent longEvent = ringBuffer.get(sequence);
            data = byteBuffer.getLong(0);
            longEvent.setValue(data);
            Thread.sleep(100L);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("生产者准备发送数据" + "当前线程" + Thread.currentThread().getName());
            ringBuffer.publish(sequence);
        }
    }

}
