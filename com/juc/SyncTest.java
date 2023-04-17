package com.juc;

import java.util.concurrent.TimeUnit;

public class SyncTest {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Thread thread1 = new Thread(() -> {
            Phone.sendA();
        }, "thread1");

        Thread thread2 = new Thread(()->{
            phone.sendSMS();
        }, "thread2");

        thread1.start();
        thread2.start();
    }
}

/**
 * 1. synchronized是悲观锁，一个对象里面如果有多个synchronized方法，某一个时刻内,
 * 只要一个线程去调用其中的一个synchronized方法了，其它的线程都只能等待，换句话说，
 * 某一个时刻内，只能有唯一的一个线程去访问这些synchronized方法，锁的是当前对象this，
 * 被锁定后，其它的线程都不能进入到当前对象的其它的synchronized方法<br/>
 *
 * 2. 当一个线程试图访问同步代码时它首先必须得到锁，正常退出或抛出异常时必须释放锁。
 * 所有的普通同步方法用的都是同一把锁即实例对象本身，就是new出来的具体实例对象本身,本类this，
 * 也就是说如果一个实例对 象的普通同步方法获取锁后，该实例对象的其他普通同步方法必须等待获取锁的方法释放锁后才能获取锁。
 * 所有的静态同步方法用的也是同一把锁-.类对象本身， 就是我们说过的唯一模板class
 * 具体实例对象this和唯一模板class, 这两把锁是两个不同的对象，所以静态同步方法与普通同步方法之间是不会有竞态条件的
 * 但是一旦一个静态同步方法获取锁后，其他的静套同步方法都必须等待该方法释放锁后才能获取锁。
 * <br/><br/>
 * 2的简而言之就是class锁和实例对象锁是不同的对象，因此静态同步方法与普通同步方法之间是不会有竞态条件的
 */
//资源类Phone
class Phone {

    public static synchronized void sendA() {
        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace();}
        System.out.println("--send A--");
    }

    public static synchronized void sendB() {
        try { TimeUnit.MILLISECONDS.sleep(500); } catch (InterruptedException e) { e.printStackTrace();}
        System.out.println("--send B--");
    }

    public synchronized void sendEmail() {
        try { TimeUnit.MILLISECONDS.sleep(1500); } catch (InterruptedException e) { e.printStackTrace();}
        System.out.println("--Send Email--");
    }

    public synchronized void sendSMS() {
        System.out.println("--Send SMS--");
    }

    public void sayHello() {
        System.out.println("hello");
    }
}