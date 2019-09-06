package com.oyo.update;

import java.io.*;
import java.math.BigInteger;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/**
 * @author liurui
 * @date 2019/8/28 14:25
 */
public class FileUtils {

    /**
     * 文件复制
     *
     * @param source
     * @param target
     */
    public static void copyFile(File source, File target) {
        FileChannel inputChannel = null;
        FileChannel outputChannel = null;
        if (!target.exists()) {
            target.getParentFile().mkdir();
            try {
                target.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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


    /**
     * 获取文件MD5码
     *
     * @param file
     * @return
     */
    public static String getFileMD5Code(File file) {
        MessageDigest digest = null;
        FileInputStream fileInputStream = null;

        if (!file.isFile()) {
            return null;
        }
        byte[] buffer = new byte[8192];
        int length;
        try {
            digest = MessageDigest.getInstance("MD5");
            fileInputStream = new FileInputStream(file);
            while ((length = fileInputStream.read(buffer)) != -1) {
                digest.update(buffer, 0, length);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 复制一个目录及其子目录、文件到另外一个目录
     * @param source
     * @param target
     * @throws IOException
     */
    public static void copyFolder(File source, File target) throws IOException {
        if (source.isDirectory()) {
            if (!target.exists()) {
                target.mkdir();
            }
            String files[] = source.list();
            for (String file : files) {

                File srcFile = new File(source, file);
                File destFile = new File(target, file);
                // 递归复制
                copyFolder(srcFile, destFile);
            }
        } else {
            InputStream in = new FileInputStream(source);
            OutputStream out = new FileOutputStream(target);

            byte[] buffer = new byte[1024];

            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
        }
    }

    public static void main(String[] args) throws IOException {
        File file1 = new File("/Users/oyo/Downloads/1.0.3");
        File file2 = new File("/Users/oyo/Downloads/1.0.4");
        copyFolder(file1,file2);
    }

}
