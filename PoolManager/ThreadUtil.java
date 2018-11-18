package com.hong.test;

/*
 * @Author hong
 * @Date 2018/11/18
 * @Function ThreadUtil类的实现
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadUtil {
	private static ExecutorService execs;
	public static List<Object> runCheckCallable(List<Callable<Object>> threadList, boolean b) throws InterruptedException,ExecutionException{
		//对参数进行检测
        if (CheckNull(threadList)) {
            return new ArrayList<>();
        }

        //初始化线程，打开一个线程池
        execs = Executors.newCachedThreadPool();
        //添加线程并返回Future线程
        List<Future<Object>> futureList = execs.invokeAll(threadList);

        if (!b){
            return new ArrayList<>();
        }
        //检查并获取线程返回值
        return getAllCallableReturn(futureList);
	}
	private static boolean CheckNull(List<Callable<Object>> threadList) {
		//检测list是否为空
        if (threadList==null||threadList.size()<1){
            return true;
        }
        //检测list中对象是否为空
        for (Callable<Object> callable :threadList){
            if (callable==null){
                return true;
            }
        }
        return false;
	}
	private static List<Object> getAllCallableReturn(List<Future<Object>> futureList) throws ExecutionException, InterruptedException {
        List<Object> returnValue = new ArrayList<>(futureList.size());//为了使性能比较好，因此将ArrayList的长度为线程数量
        while(true){
            Iterator<Future<Object>> iterator = futureList.iterator();
            while(iterator.hasNext()){
                Future<Object> future = iterator.next();
                if (future.isDone()){
                    Object o = future.get();
                    returnValue.add(o);
                    iterator.remove();
                }
            }
            if (futureList.size()==0){
                break;
            }
            TimeUnit.MILLISECONDS.sleep(10*1000);
        }
        return returnValue;
    }
}
