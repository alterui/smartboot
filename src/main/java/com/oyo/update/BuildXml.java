package com.oyo.update;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liurui
 * @date 2019/9/5 20:07
 */
public class BuildXml {

    static List<String> list = new ArrayList();

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
     * 生成xml
     * @param sourcePath
     * @param targetPath
     */
    public static void createXMLByDOM(String version,String sourcePath,String targetPath) {

        File source = new File(sourcePath);
        File source1 = new File(targetPath + File.separator + version);
        File target = new File(targetPath + File.separator + version+File.separator+"file.xml");

        dirCopy(sourcePath, targetPath + File.separator + version);


        // 创建DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            // 创建DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 创建Document
            Document document = builder.newDocument();

            // 设置XML声明中standalone为yes，即没有dtd和schema作为该XML的说明文档，且不显示该属性
            // document.setXmlStandalone(true);
            // 创建根节点
            Element files = document.createElement("files");

            //version节点
            Element fileVersion = document.createElement("version");
            fileVersion.setTextContent(version);
            files.appendChild(fileVersion);

            List<String> fileAbsolutePath = getFileAbsolutePath(source1);
            for (int i = 0; i < fileAbsolutePath.size(); i++) {
                // 创建子节点，并设置属性
                Element  file = document.createElement("file");
                file.setAttribute("id", String.valueOf(i+1));


                // 添加子节点
                Element fileName = document.createElement("fileName");
                fileName.setTextContent(new File(fileAbsolutePath.get(i)).getName());
                file.appendChild(fileName);

                // 添加子节点
                Element filePathName = document.createElement("filePath");
                String path = fileAbsolutePath.get(i).substring(fileAbsolutePath.get(i).indexOf(source1.getName()), fileAbsolutePath.get(i).length());
                String newPath = path.substring(path.indexOf("/"),path.length());
                filePathName.setTextContent(newPath.substring(1));
                file.appendChild(filePathName);


                // 添加子节点
                Element fileMD5Code = document.createElement("fileMD5Code");
                fileMD5Code.setTextContent(getFileMD5Code(new File(fileAbsolutePath.get(i))));
                file.appendChild(fileMD5Code);

                // 为根节点添加子节点
                files.appendChild(file);
            }

            // 将根节点添加到Document下
            document.appendChild(files);

            /**
             * 生成XML文件
             */
            // 创建TransformerFactory对象
            TransformerFactory tff = TransformerFactory.newInstance();
            // 创建Transformer对象
            Transformer tf = tff.newTransformer();
            // 设置输出数据时换行
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            // 使用Transformer的transform()方法将DOM树转换成XML
            tf.transform(new DOMSource(document), new StreamResult(target));

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

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

    public static void main(String[] args) {

        createXMLByDOM("1.1.2","/Users/oyo/Downloads/IOTPMS","/Users/oyo/Downloads/target");

        //createXMLByDOM(args[0],args[1],args[2]);
        // STOPSHIP: 2019/9/6

    }


}
