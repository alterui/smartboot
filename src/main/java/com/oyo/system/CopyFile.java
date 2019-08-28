package com.oyo.system;


import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author liurui
 * @date 2019/8/28 10:28
 */
public class CopyFile {
    public static void main(String[] args) {
        File sourceFile = new File("C:\\myData\\lock\\client.exe");
        File destFile = new File("C:\\lock3\\client.exe");

        long beforeTime = System.currentTimeMillis();

        copyFile(sourceFile, destFile);
        System.out.println(System.currentTimeMillis()-beforeTime);

    }

    public static void copyFile(File source, File dest) {

        if (!dest.exists()) {
            dest.getParentFile().mkdir();
            try {
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();

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
