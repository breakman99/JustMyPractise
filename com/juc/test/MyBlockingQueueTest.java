package com.juc.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueTest {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(5);
        Thread t1 = new Thread(() -> {
            int count = 0;
            while (true) {
                try { TimeUnit.MILLISECONDS.sleep(150); } catch (InterruptedException e) { e.printStackTrace();}
                queue.put(count++);
                try { TimeUnit.MILLISECONDS.sleep(150); } catch (InterruptedException e) { e.printStackTrace();}
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            while (true) {
                try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace();}
                queue.get();
                try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace();}
            }
        }, "t2");
        t1.start();
        try { TimeUnit.MILLISECONDS.sleep(3000); } catch (InterruptedException e) { e.printStackTrace();}
        t2.start();
        try { TimeUnit.MILLISECONDS.sleep(6000); } catch (InterruptedException e) { e.printStackTrace();}
    }
}


class MyBlockingQueue {
    private final Object[] list;
    private final int capacity;
    private int count;
    private int head = 0;
    private int tail = 0;

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        list = new Object[capacity];
    }

    public void put(Object obj) {
        lock.lock();
        try {
            while (count >= capacity) {
                notFull.await();
            }
            count++;
            list[tail] = obj;
            tail = (tail + 1) % capacity;
            System.out.println(Thread.currentThread().getName() + " - put obj: "+ (Integer) obj +" - now count:" + count);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public Object get() {
        Object obj = null;
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            count--;
            obj = list[head];
            head = (head + 1) % capacity;
            System.out.println(Thread.currentThread().getName() + " - get obj: "+ (Integer) obj +" - now count:" + count);
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return obj;
    }
}
