package com.gjs.antclass.class0008;

import com.lmax.disruptor.EventHandler;

/**
 * MyEventHandle
 *
 * @author gujiashun
 * @date 2021/2/23
 */
public class MyEventHandle implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        System.out.println("消费者MyEventHandle获取数据：" + longEvent.getValue() + "当前线程" + Thread.currentThread().getName());
    }
}
