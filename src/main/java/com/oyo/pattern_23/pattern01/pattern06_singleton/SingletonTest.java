package com.oyo.pattern_23.pattern01.pattern06_singleton;

/**
 * 静态内部类
 *
 * @author liurui
 * @date 2019/9/17 11:02
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1==instance2);
    }
}

class Singleton {
    private Singleton() {

    }
    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static  Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

