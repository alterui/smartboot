package com.oyo.update;

import java.io.File;

/**
 * @author liurui
 * @date 2019/9/5 17:36
 */
public class FileTest {

        public static void main(String[] args) {

            getFileAbsolutePath(new File("/Users/oyo/Downloads/picture"));
        }
        public static void getFileAbsolutePath(File file){
            if (file.exists()) {
                File[] files = file.listFiles();
                if (files==null ) {
                    System.out.println("文件夹下无目录（空）!");
                } else {
                    for (File fileName : files) {
                        if (fileName.isDirectory()) {
                            System.out.println("文件夹:" + fileName.getPath());
                            getFileAbsolutePath(fileName);
                        } else {
                            System.out.println("文件:" + fileName.getPath());
                        }
                    }
                }
            } else {
                System.out.println("文件不存在!");
            }
        }


}
