package com.gjs.antclass.class0008;

import com.lmax.disruptor.EventFactory;

/**
 * MyEventFactory
 *
 * @author gujiashun
 * @date 2021/2/23
 */
public class MyEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }

}
