package com.juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Async 会另外使用它自带的线程池，不带Async的就是会接着你之前用的线程池
public class CompletableFutureWithThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println("hello world");
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        try {
            CompletableFuture.supplyAsync(() -> "ResultA", threadPool)
                    .thenRun(() -> {
                        try { TimeUnit.MILLISECONDS.sleep(50); } catch (InterruptedException e) { e.printStackTrace();}
                        System.out.println(Thread.currentThread().getName());
                    }).thenRun(() -> {
                        try { TimeUnit.MILLISECONDS.sleep(50); } catch (InterruptedException e) { e.printStackTrace();}
                        System.out.println(Thread.currentThread().getName());
                    }).thenRunAsync(() -> {
                        try { TimeUnit.MILLISECONDS.sleep(50); } catch (InterruptedException e) { e.printStackTrace();}
                        System.out.println(Thread.currentThread().getName());
                    }).thenRunAsync(() -> {
                        try { TimeUnit.MILLISECONDS.sleep(50); } catch (InterruptedException e) { e.printStackTrace();}
                        System.out.println(Thread.currentThread().getName());
                    });
            try { TimeUnit.MILLISECONDS.sleep(2000); } catch (InterruptedException e) { e.printStackTrace();}
        } finally {
            threadPool.shutdown();
        }
    }
}
