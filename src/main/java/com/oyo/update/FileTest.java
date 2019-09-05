package com.oyo.update;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2019/9/5 17:36
 */
public class FileTest {

        public static void main(String[] args) {

            List<String> fileAbsolutePath = getFileAbsolutePath(new File("/Users/oyo/Downloads/picture"));

            fileAbsolutePath.forEach(System.out::println);
            String s = fileAbsolutePath.get(0);
            File file = new File(s);
            System.out.println(file.getName());
        }
        public static List<String > getFileAbsolutePath(File file){
            List<String> list = new ArrayList();
            if (file.exists()) {
                File[] files = file.listFiles();
                if (files==null ) {
                    System.out.println("文件夹下无目录（空）!");
                } else {
                    for (File fileName : files) {
                        if (fileName.isDirectory()) {
                           // System.out.println("文件夹:" + fileName.getPath());
                            getFileAbsolutePath(fileName);
                        } else {
                            //System.out.println("文件:" + fileName.getPath());
                            list.add(fileName.getPath());
                        }
                    }
                }
            } else {
                return null;
            }
            return list;
        }


}
