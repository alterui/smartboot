package com.oyo.test;

/**
 * @author liurui
 * @date 2019/9/9 16:31
 */
public class Child extends Person {
    int num = 3;
    int age = 20;

    public void eat() {
        System.out.println("小孩再吃");
    }

    public static void sleep() {
        System.out.println("小孩在睡觉");
    }

    public void cry() {
        System.out.println("小孩在哭");

    }

}
