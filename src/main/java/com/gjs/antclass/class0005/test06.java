package com.gjs.antclass.class0005;

/**
 * test06 future模式原理
 *
 * @author gujiashun
 * @date 2021/2/1
 */
public class test06 {

    public static void main(String[] args) {
        FutureClient futureClient = new FutureClient();
        Data submit = futureClient.submit("567");
        long l, l1 = 0;
        try {
            l = System.currentTimeMillis();
            System.out.println("数据发送成功");
            Thread.sleep(1000L);
            l1 = System.currentTimeMillis();
            System.out.println("主线程休息结束" + (l1 - l));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(submit.getRequest() + (System.currentTimeMillis() - l1));
    }

}

class FutureClient {

    public Data submit(String param) {
        FutureData futureDate = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(param);
                futureDate.setRealData(realData);
            }
        }, "input thread name").start();
        return futureDate;
    }
}

interface Data{
    String getRequest();
}

class FutureData implements Data {
    public volatile static boolean ISFLAG = false;
    private RealData realData;
    public synchronized void setRealData(RealData realData) {
        // 如果已经获取到结果，直接返回
        if (ISFLAG) {
            return;
        }
        // 如果没有获取到结果,传递真对象
        this.realData = realData;
        ISFLAG = true;
        // 进行通知
        notify();
    }
    @Override
    public synchronized String getRequest() {
        while (!ISFLAG) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return realData.getRequest();
    }
}

class RealData implements Data {

    private String result;

    public RealData(String param) {
        System.out.println("正在进行请求，参数：" + param);
        try {
            Thread.sleep(3000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("操作执行完毕，获取到结果");
        this.result = param + param + param;
    }
    @Override
    public String getRequest() {
        return result;
    }
}