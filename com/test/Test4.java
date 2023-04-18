package com.test;


// 单例模式的举例
public class Test4 {
    public static void main(String[] args) {

    }
}

// 非线程安全
class Singleton1 {
    private static Singleton1 instance;
    private Singleton1(){}
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}

// 线程安全并且高效
class Singleton2 {
    private static Singleton2 instance;
    private Singleton2(){}
    public static Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}