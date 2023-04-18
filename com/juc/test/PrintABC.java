package com.juc.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadR(0), "t1");
        Thread t2 = new Thread(new ThreadR(1), "t2");
        Thread t3 = new Thread(new ThreadR(2), "t3");
        t1.start();
        t2.start();
        t3.start();
        try { TimeUnit.MILLISECONDS.sleep(5000); } catch (InterruptedException e) { e.printStackTrace();}
    }
}

class ThreadR implements Runnable {
    private Integer id;
    private static int count = 0;
    private static int maxCount = 50;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();


    public ThreadR(Integer id) {
        this.id = id;
    }
    @Override
    public void run() {
        while (count < maxCount) {
            try {
                lock.lock();
                while (count % 3 != id) {
                    condition.await();
                }
                try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace();}
                System.out.print((char)('A' + id));
                count++;
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
