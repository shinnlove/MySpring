/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.xml;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * XML学习
 *
 * @author shinnlove.jinsheng
 * @version $Id: LearnXML.java, v 0.1 2017-09-16 下午9:47 shinnlove.jinsheng Exp $$
 */
public class LearnXML {

    //    private static Logger logger = LoggerFactory.getLogger(LearnXML.class);

    //    private static Logger logger  = Logger.getLogger(LearnXML.class);

    //    private static Log logger = LogFactory.getLog(LearnXML.class);

    /** 包装了resource bundle的日志，其实可以用原生的apache.common.logging的Logger */
    //    private static final Logger logger = LoggerFactory.getLogger(LearnXML.class);

    public static void main(String[] args) {
        try {
            // 先锁定文件
            String filePath = "/Users/zhaochensheng/Downloads/test_scan.xml";

            Path path = Paths.get(filePath);
            File file = path.toFile();

            // 再得到XML对象
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder builder = factory.newDocumentBuilder();

                Document doc = builder.parse(file);

                Element root = doc.getDocumentElement();

                scanEachChildElement(root);
            } catch (ParserConfigurationException e) {
                // newDocumentBuilder会引发
                e.printStackTrace();

                //            LoggerUtil.warn(logger, "ParserConfigurationException出错了", e);
                //                logger.error("ParserConfigurationException", e);
            } catch (SAXException e) {
                // parse会引发
                e.printStackTrace();

                //            LoggerUtil.warn(logger, "SAXException出错了", e);
                //                logger.error("SAXException", e);
            } catch (IOException e) {
                // parse会引发
                e.printStackTrace();

                //            LoggerUtil.warn(logger, "IOException出错了", e);
                //                logger.error("IOException", e);
                throw new RuntimeException("new Exception", e);
            } catch (Exception e) {

                //            LoggerUtil.warn(logger, "Exception出错了", e);
                //                logger.error("Exception", e);
            }
        } catch (Exception e) {
            //            logger.error("总的错误是", e);
        }

    }

    /**
     * 扫描一个XML结点下的所有子结点
     *
     * @param element 一个XML的Element元素
     */
    private static void scanEachChildElement(Element element) {
        String tagName = element.getTagName();
        System.out.print("<" + tagName);
        scanElementAttributes(element);

        NodeList children = element.getChildNodes(); // 重要1：校验一个结点下是否还有子节点
        if (children != null && children.getLength() > 0) {

            System.out.print(">"); // 有子元素先闭合自身

            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i); // 重要2：循环获取每个子节点

                if (child instanceof Element) {
                    System.out.println();
                    System.out.print("\t"); // Element节点类型的子元素缩进4个字符

                    scanEachChildElement((Element) child); // 递归扫描子节点
                }

                // 处理结点只是文本child
                if (child instanceof Text) {
                    Text textNode = (Text) child;
                    String text = trimStr(textNode.getData().trim());
                    if (!"".equals(text)) {
                        System.out.print(text);
                    }
                }

            }
            System.out.println("</" + tagName + ">");
        } else {
            System.out.println("/>"); // 普通元素且没有子元素直接闭合自身标签
        }
    }

    /**
     * 扫描并打印一个XML节点上的所有属性名与属性值
     *
     * @param element 一个XML结点Element元素
     */
    private static void scanElementAttributes(Element element) {
        // 先输出属性名 重要4：获取节点上的属性名和value
        NamedNodeMap attributes = element.getAttributes();
        for (int j = 0; j < attributes.getLength(); j++) {
            Node attribute = attributes.item(j);
            String name = attribute.getNodeName();
            String value = attribute.getNodeValue();

            System.out.print(" " + name + "=\"" + value + "\"");
        }
    }

    /**
     * 清楚字符串中的特殊字符。
     * 
     * @param needTrim
     * @return
     */
    private static String trimStr(String needTrim) {
        needTrim.replaceAll("\n", "");
        needTrim.replaceAll("\t", "");
        needTrim.replaceAll("\r", "");
        return needTrim;
    }

}