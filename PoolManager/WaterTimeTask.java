package com.hong.test;

import com.hong.test.ThreadUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * 定期放水类
 * Created by hong on 2018/11/18.
 */
public class WaterTimeTask extends TimerTask {

    @Override
    public void run() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(100);
        InputThread thread1 = new InputThread(queue);
        OutputThread thread2 = new OutputThread(queue);
        List<Callable<Object>> threadList = new ArrayList<>(2);
        threadList.add(thread1);
        threadList.add(thread2);
        List<Object> returnValue = null;
        try {
            returnValue = ThreadUtil.runCheckCallable(threadList,true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("泳池已经注满");
        System.out.println(returnValue.get(0));
        System.out.println(returnValue.get(1));
    }
}