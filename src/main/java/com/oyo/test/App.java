package com.oyo.test;

import org.checkerframework.checker.units.qual.A;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2019/9/9 16:33
 */
public class  App extends Thread{

    public volatile static int count;

    private  static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        addCount();
    }

    public static void main(String[] args) {
      App[] app =  new App[100];

        for (int i = 0; i < 100; i++) {
            app[i] = new App();
        }

        for (int i = 0; i < 100; i++) {
            app[i].start();
        }

    }

}
