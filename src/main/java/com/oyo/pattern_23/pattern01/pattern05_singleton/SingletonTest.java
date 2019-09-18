package com.oyo.pattern_23.pattern01.pattern05_singleton;

/**
 * 双重检查
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
    //为了避免初始化操作的指令重排序
    private static volatile Singleton singleton;

    public static  Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }

            }
        }
        return singleton;
    }
}

