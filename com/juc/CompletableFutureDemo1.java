package com.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Future相关入门知识<br/>
 *
 */
public class CompletableFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallableThread());
        Thread thread = new Thread(futureTask, "thread");
        thread.start();
        System.out.println("---main thread running---");
        //这个地方是future task获取这个thread call回来的值，会阻塞，正常可以用一个带timeout逻辑的get
        System.out.println(futureTask.get());

    }
}

class MyCallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("---");
        System.out.println("MyCallableThread" + Thread.currentThread().getName() + " start");
        System.out.println("---");
        return "hello MyCallableThread";
    }
}