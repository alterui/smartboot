package com.oyo.system;


import java.io.*;
import java.nio.channels.FileChannel;

/**
 * @author liurui
 * @date 2019/8/28 10:28
 */
public class CopyFile {
    public static void main(String[] args) {
        File sourceFile = new File("/Users/oyo/Documents/book/Java核心技术卷2.pdf");
        File destFile = new File("/Users/oyo/Documents/book3/1.pdf");

        long beforeTime = System.currentTimeMillis();

        copyFile(sourceFile, destFile);
        System.out.println(System.currentTimeMillis()-beforeTime);

    }

    public static void copyFile(File source, File dest) {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;

        try {
            inputChannel = new FileInputStream(source).getChannel();
            outputChannel = new FileOutputStream(dest).getChannel();

            outputChannel.transferFrom(inputChannel, 0, inputChannel.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
