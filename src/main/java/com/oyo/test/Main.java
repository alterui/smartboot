package com.oyo.test;

/**
 * @author liurui
 * @date 2019/9/18 12:11
 */
public class Main {
    private volatile static boolean flag = true;

    public static  void main(String[] args)  {

        Thread thread1 = new Thread(() -> {
            System.out.println("线程1开始执行了");
            while (flag) {

            }
            System.out.println("线程1执行结束了");

        });


        Thread thread2 = new Thread(() -> {
            System.out.println("线程2开始执行了");
            while (!flag) {

            }
            System.out.println("线程2执行结束了");

        });

        thread1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        flag = false;
        thread2.start();

    }
}
