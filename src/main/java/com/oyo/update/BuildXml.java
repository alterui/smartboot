package com.oyo.update;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

/**
 * @author liurui
 * @date 2019/9/5 20:07
 */
public class BuildXml {
    public static void createXMLByDOM(File source,File target) {
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

            Element fileVersion = document.createElement("version");
            fileVersion.setTextContent(source.getName());
            files.appendChild(fileVersion);

            List<String> fileAbsolutePath = FileTest.getFileAbsolutePath(source);
            for (int i = 0; i < fileAbsolutePath.size(); i++) {
                // 创建子节点，并设置属性
                Element  file = document.createElement("file");
                file.setAttribute("id", String.valueOf(i+1));

                // 添加子节点
                Element filePathName = document.createElement("filePath");
                filePathName.setTextContent(fileAbsolutePath.get(i));
                file.appendChild(filePathName);

                // 添加子节点
                Element fileName = document.createElement("fileName");
                fileName.setTextContent(new File(fileAbsolutePath.get(i)).getName());
                file.appendChild(fileName);

                // 添加子节点
                Element fileMD5Code = document.createElement("fileMD5Code");
                fileMD5Code.setTextContent(FileUtils.getFileMD5Code(new File(fileAbsolutePath.get(i))));
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

    public static void main(String[] args) {
        createXMLByDOM(new File("/Users/oyo/Downloads/1.0.2"),new File("/Users/oyo/Downloads/1.0.2/file.xml"));
    }
}
