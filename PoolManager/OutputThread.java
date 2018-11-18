package com.hong.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 放水线程
 * Created by captain on 2018/11/18.
 */

public class OutputThread implements Callable<Object>{

    private BlockingQueue<String> queue;

    public OutputThread(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public Object call() throws InterruptedException {
        while(true){
        	System.out.println("放放");
        	System.out.println("放");
            if(queue.size()==100){
                break;
            }
            for(int cnt=0;cnt<3;cnt++){
                queue.poll(5,TimeUnit.SECONDS);
            }
            System.out.println("放水3立方米，当前水量："+queue.size());
            TimeUnit.SECONDS.sleep(1);
        }
        return "success";
    }
}
