package com.oyo.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.X509Certificate;

/**
 * @author liurui
 * @date 2019/8/27 15:44
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("/Users/oyo/Documents/book/test.txt");
        File file1 = new File("/Users/oyo/Documents/book/test1.txt");
        String fileMD5 = getFileMD5(file);
        System.out.println(fileMD5);

        String fileMD51 = getFileMD5(file1);
        System.out.println(fileMD51);

        System.out.println("文件1的长度："+file.length());
        System.out.println("文件2的长度："+file1.length());

    }


    // 计算文件的 MD5 值
    public static String getFileMD5(File file) {

        if (!file.isFile()) {
            return null;
        }

        long before = System.currentTimeMillis();


        MessageDigest digest = null;
        FileInputStream fileInputStream = null;
        byte buffer[] = new byte[8192];
        int length;
        try {
            digest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            while ((length = fileInputStream.read(buffer)) != -1) {
                digest.update(buffer, 0, length);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            System.out.println(System.currentTimeMillis()-before);
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }



}
