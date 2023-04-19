package com.juc.test;

import java.util.concurrent.TimeUnit;

public class DeadLockDemo {
    public static void main(String[] args) {
        System.out.println();
        Object a = new Object();
        Object b = new Object();
        new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + " get lock a");
                try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + " get lock b");
                }
            }
        }, "t1").start();
        new Thread(() -> {
            synchronized (b) {
                System.out.println(Thread.currentThread().getName() + " get lock b");
                try { TimeUnit.MILLISECONDS.sleep(1000); } catch (InterruptedException e) { e.printStackTrace();}
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + " get lock a");
                }
            }
        }, "t2").start();
    }


}
