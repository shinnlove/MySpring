/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.excel;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * 使用jxl读取excel
 *
 * @author shinnlove.jinsheng
 * @version $Id: ReadExcel.java, v 0.1 2017-12-04 下午8:39 shinnlove.jinsheng Exp $$
 */
public class ReadExcel {

    public static void main(String[] args) {
        try {
            //hello.xls为要读取的excel文件名
            Workbook book = Workbook.getWorkbook(new File(
                "/Users/zhaochensheng/Downloads/201712042047492855.xls"));

            //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            Sheet sheet = book.getSheet(0);
            //获取左上角的单元格
            Cell themeCell = sheet.getCell(0, 0);
            System.out.println("Excel第一行的标题：" + themeCell.getContents());

            int rowCount = sheet.getRows(); // 得到包含标题、表头和数据的所有行数
            int columnCount = sheet.getColumns(); // 得到所有的列

            System.out.println("当前Excel包含标题、表头和数据的总行数有" + rowCount + "行。");
            System.out.println("当前Excel总列数有" + columnCount + "列。");

            // 打印表头（表头从第二行开始）
            for (int k = 0; k < columnCount; k++) {
                Cell titleCell = sheet.getCell(k, 1); // 特别注意：（列，行），第二行是表头，row=1
                // 输出这一行数据
                System.out.print(titleCell.getContents() + "\t");
            }
            System.out.println(); // 表头换行

            // 打印数据
            for (int i = 2; i < rowCount; i++) {
                // 循环行
                for (int j = 0; j < columnCount; j++) {
                    // 循环列
                    Cell dataCell = sheet.getCell(j, i); // 特别注意：（列，行）
                    // 输出这一行数据
                    System.out.print(dataCell.getContents() + "\t");
                }
                System.out.println(); // 一行数据结束就换行
            }

            book.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}