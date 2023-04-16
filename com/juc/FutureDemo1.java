package com.juc;

import java.util.concurrent.*;

/**
 * Future相关入门知识<br/>
 * 1. future对结果的获取不友好，只能通过轮询的方式获取，会消耗CPU资源<br/>
 */
public class FutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyCallableThread());
        Thread thread = new Thread(futureTask, "thread");
        thread.start();
        System.out.println("---main thread running---");
        // 轮询的方式获取结果会耗费CPU资源
        while (true) {
            if (futureTask.isDone()) {
                //这个地方是future task获取这个thread call回来的值，会阻塞，正常可以用一个带timeout逻辑的get，比如futureTask.get(3, TimeUnit.SECONDS)
                System.out.println(futureTask.get());
                break;
            } else {
                try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace();}
                System.out.println("waiting future task...");
            }
        }

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


/**
 * 展示了FutureTask与线程池的结合用法，因为不能一直new thread，这样的话new出来的线程最终会交给守护线程去销毁，销毁的步骤会占用资源
 */
class FutureThreadPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long startTime = System.currentTimeMillis();
        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace();}
        try { TimeUnit.MILLISECONDS.sleep(600); } catch (InterruptedException e) { e.printStackTrace();}
        try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace();}
        long endTime = System.currentTimeMillis();
        System.out.println("use time: " + (endTime - startTime));

        ExecutorService threadPool = null;
        try {
            threadPool = Executors.newFixedThreadPool(3);
            long startTime2 = System.currentTimeMillis();
            FutureTask<Integer> futureTask = new FutureTask<>(() -> {
                try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace();}
                return 500;
            });
            threadPool.submit(futureTask);
            FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
                try { TimeUnit.MILLISECONDS.sleep(600); } catch (InterruptedException e) { e.printStackTrace();}
                return 500;
            });
            threadPool.submit(futureTask2);
            //get result from task1 and task2
            System.out.println("get futureTask1 result:"+futureTask.get());
            System.out.println("get futureTask2 result:"+futureTask2.get());
            try { TimeUnit.MILLISECONDS.sleep(300); } catch (InterruptedException e) { e.printStackTrace();}
            long endTime2 = System.currentTimeMillis();
            System.out.println("multiple thread use time: " + (endTime2 - startTime2));
        } finally {
            if (threadPool != null) threadPool.shutdown();
        }
    }
}

