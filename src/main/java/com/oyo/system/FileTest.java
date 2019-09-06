package com.oyo.system;

import com.oyo.update.FileUtils;

import java.io.*;

/**
 * @author liurui
 * @date 2019/9/6 15:10
 */
//import org.apache.commons.io.FileUtils;

public class FileTest {
    public static void main(String[] args) throws IOException {
        //long start = System.currentTimeMillis();
        //递归实现文件夹的拷贝
        dirCopy("/Users/oyo/Downloads/1.0.3", "/Users/oyo/Downloads/1.0.4");
        //System.out.println(System.currentTimeMillis()-start);
        //start = System.currentTimeMillis();
        //Commons-IO实现文件夹拷贝
        //FileUtils.copyDirectory(new File("src"), new File("src2"));
        //System.out.println(System.currentTimeMillis()-start);

    }

    public static void dirCopy(String srcPath, String destPath) {
        File src = new File(srcPath);
        if (!new File(destPath).exists()) {
            new File(destPath).mkdirs();
        }
        File[] files = src.listFiles();
        if (files == null) {
            System.out.println("原文件没有文件");
        }
        for (File s : files) {
            if (s.isFile()) {
                fileCopy(s.getPath(), destPath + File.separator + s.getName());
            } else {
                dirCopy(s.getPath(), destPath + File.separator + s.getName());
            }
        }
    }

    public static void fileCopy(String srcPath, String destPath) {
        File src = new File(srcPath);
        File dest = new File(destPath);
        //使用jdk1.7 try-with-resource 释放资源，并添加了缓存流
        try(InputStream is = new BufferedInputStream(new FileInputStream(src));
            OutputStream out =new BufferedOutputStream(new FileOutputStream(dest))) {
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                out.write(flush, 0, len);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

