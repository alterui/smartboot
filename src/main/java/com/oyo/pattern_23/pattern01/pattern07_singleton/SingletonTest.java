package com.oyo.pattern_23.pattern01.pattern07_singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 静态内部类
 *
 * @author liurui
 * @date 2019/9/17 11:02
 */
public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("22");
        Singleton instance1 = Singleton.INSTANCE;
        System.out.println("33");
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println("44");


        System.out.println(instance1==instance2);


    }
}


enum Singleton{
    INSTANCE,;
    private Singleton() {
        System.out.println("11");
    }
}

