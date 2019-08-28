package com.oyo.system;


import sun.reflect.misc.FieldUtil;

import java.io.*;
import java.nio.channels.FileChannel;
/**
 * @author liurui
 * @date 2019/8/28 10:28
 */
public class CopyFile {
    public static void main(String[] args) {
     /*   File sourceFile = new File("C:\\myData\\lock\\client.exe");
        File destFile = new File("C:\\lock4\\client.exe");*/

        File sourceFile = new File("/Users/oyo/Documents/book/Java8实战.pdf");
        File destFile = new File("/Users/oyo/Documents/book1/Java8实战.pdf");



        long beforeTime = System.currentTimeMillis();

        copyFile(sourceFile, destFile);
        System.out.println(System.currentTimeMillis()-beforeTime);


    }

    public static void copyFile(File source, File target) {
        if (!target.exists()) {
            target.getParentFile().mkdir();
            try {
                target.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(target).getChannel();
            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputChannel != null) {
                    inputChannel.close();
                }
                if (outputChannel != null) {
                    outputChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
