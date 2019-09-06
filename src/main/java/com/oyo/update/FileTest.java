package com.oyo.update;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2019/9/5 17:36
 */
public class FileTest {
    static List<String> list = new ArrayList();

    public static void main(String[] args) {
        List<String> fileAbsolutePath = getFileAbsolutePath(new File("/Users/oyo/Downloads/picture"));
        fileAbsolutePath.forEach(System.out::println);
        String s = fileAbsolutePath.get(0);
        File file = new File(s);
        System.out.println(file.getName());
    }

    /**
     * 获取文件下的所有的文件名
     * @param file
     * @return
     */
    public static List<String> getFileAbsolutePath(File file) {
        if (file.exists()) {
            File[] files = file.listFiles();
            if (files == null) {
                System.out.println("文件夹下无目录!");
            } else {
                for (File fileName : files) {
                    if (fileName.isDirectory()) {
                        //System.out.println("文件夹:" + fileName.getPath());
                        //list.add(fileName.getPath());
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
