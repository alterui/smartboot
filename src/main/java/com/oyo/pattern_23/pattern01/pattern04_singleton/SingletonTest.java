package com.oyo.pattern_23.pattern01.pattern04_singleton;

/**
 * 懒汉式(线程安全)
 * 使用synchronized同步方法
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

    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

