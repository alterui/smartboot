package com.oyo.test;

/**
 * @author liurui
 * @date 2019/9/18 11:17
 */
public class Application {
     static  int i = 0;

    public static void main(String[] args) throws InterruptedException {

        synchronized(Application.class) {
            while (true) {
                new Thread(()->{
                    i=100;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();

                new Thread(()->{
                    i = 400;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }).start();

                System.out.println(i);
            }


        }



    }

}
