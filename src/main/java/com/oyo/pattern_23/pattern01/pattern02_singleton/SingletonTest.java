package com.oyo.pattern_23.pattern01.pattern02_singleton;

/**
 * 饿汉式(静态代码块)
 *
 * @author liurui
 * @date 2019/9/17 11:02
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1.hashCode()+","+instance2.hashCode());
    }
}

class Singleton {
    private Singleton() {

    }
    private static Singleton singleton;
    static {
        singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return singleton;
    }
}

