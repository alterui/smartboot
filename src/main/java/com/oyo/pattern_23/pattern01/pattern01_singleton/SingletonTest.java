package com.oyo.pattern_23.pattern01.pattern01_singleton;

/**
 * 饿汉式(静态常量)
 *
 * @author liurui
 * @date 2019/9/15 10:23
 */
public class SingletonTest {


    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1==singleton2);
    }



}

class Singleton {
    private Singleton() {

    }

    private static final Singleton singleton = new Singleton();

    public static Singleton getInstance() {
        return singleton;
    }
}
