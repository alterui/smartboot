package com.oyo.test;

/**
 * @author liurui
 * @date 2019/9/18 12:01
 */
public class RunThread extends Thread {
    private  boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        System.out.println("进入到run方法中");
        while (isRunning == true) {

        }

        System.out.println("线程执行完了");
    }





}
