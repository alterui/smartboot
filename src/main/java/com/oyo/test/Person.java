package com.oyo.test;

import java.io.Serializable;

/**
 * @author liurui
 * @date 2019/9/6 18:49
 */
public class Person implements Serializable {
        int num =1 ;
        static int age = 23;

        public void eat() {
            System.out.println("人在吃饭");
        }

        public static void sleep() {
            System.out.println("人在睡觉");
        }

        public void run() {
            System.out.println("人在跑步");
        }
}
