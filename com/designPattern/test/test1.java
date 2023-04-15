package com.designPattern.test;

public class test1 {
    public static void main(String[] args) {
        FlyDuck flyDuck = new FlyDuck();
        flyDuck.fly();
    }
}

abstract class Duck {
    public void swim(){
        System.out.println("swim");
    };
    public abstract void display();
}

interface CanFly {
    default void fly() {
        System.out.println("[default] I can fly");
    }
}

class DuckA extends Duck {

    @Override
    public void display() {
        System.out.println("displayA---");
    }
}

class DuckB extends Duck {

    @Override
    public void display() {
        System.out.println("displayB+++");
    }
}

class FlyDuck extends Duck implements CanFly {
    @Override
    public void display() {
        System.out.println("displayFly...");
    }
}






















