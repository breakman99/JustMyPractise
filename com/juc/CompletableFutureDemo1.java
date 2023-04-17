package com.juc;


import java.util.Random;
import java.util.concurrent.*;

/**
 * this demo introduced the use of CompletableFuture
 */
public class CompletableFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //用CompletableFuture完成和Future一样的功能，get同样会阻塞住线程
        futureFunc();
        completableFutureFunc();
    }

    //流式操作，用whenComplete来进入下一个stage（阶段
    private static void completableFutureFunc() {
        //这里传入自己自定义的线程池则需要自己关闭，不传入的话，使用CompletableFuture默认的线程池则会随着main线程关闭而关闭
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            String res = "hello world";
            try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace();}
            if (new Random().nextInt(5) > 3) {
                res = "hello java";
            }
            return res;
        }, threadPool).whenComplete((v, e) -> {
            System.out.println("calculate completed, result: " + v);
        }).exceptionally(throwable -> {
            throwable.printStackTrace();
            return throwable.getMessage();
        });
        completableFuture.join();
        threadPool.shutdown();

    }

    private static void futureFunc() throws ExecutionException, InterruptedException {
        // 无返回值并且不指定线程池（会内部给你一个线程池）
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("run a thread" + Thread.currentThread().getName());
            try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
            System.out.println("thread done");
        });
        System.out.println(completableFuture.get());


        // 无返回值但有线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
            System.out.println("run a thread:" + Thread.currentThread().getName());
            try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
            System.out.println("thread done");
        }, threadPool);
        System.out.println(completableFuture1.get());
        threadPool.shutdown();

        // 有返回值并且指定自己的线程池
        ExecutorService threadPool2 = Executors.newFixedThreadPool(3);
        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply example, run a thread" + Thread.currentThread().getName());
            try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace();}
            return "Hello world";
        }, threadPool2);
        System.out.println(completableFuture2.get());
        threadPool2.shutdown();
    }
}
