package com.oyo.pattern_23.pattern01.pattern03_singleton;

/**
 * 懒汉式(线程不安全)
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
    /**
     * 当调用的时候再创建对象，但是线程不安全。比如线程1执行到singleton为空，此时线程2也执行到此为止，然后就会产生两个对象。
     * @return
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

