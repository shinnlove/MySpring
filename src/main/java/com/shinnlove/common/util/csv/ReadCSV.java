/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.csv;

import java.io.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 读取csv表格
 *
 * 注意：读取csv表格一般都是整行读入，然后用分隔符分隔读取内容，再做类型转换。
 *
 * 本次对账单的csv数据：
 * =========csv内容begin，一行内容对应一行号，从1开始，不包括本句话描述=========
 * #起始日期：2015-03-01 00:00:00 终止日期：2015-03-28 23:59:59
 * #交易金额合计：1笔，共24.00元,
 * #下载时间：2017-12-04 21:14:25
 *
 * 交易时间,微信支付单号,商户订单号,商户号,特约商户号,设备号,appid,下单用户,交易场景,交易状态,支付成功时间,交易金额(元)
 * 2015-03-09 02:28:27,1001230314201503090029378209	,abefab67c1e0b9a7f0809c2f2a511215	,10029370	,	,,wxdb3bb7c95c0d5932,oeovpt2GxdVPZRZGB9z_QWGXuKrY,公众号支付,买家已支付,2015-03-09 02:28:27,24.00
 * =========csv内容end，不包括本句话描述=========
 *
 * @author shinnlove.jinsheng
 * @version $Id: ReadCSV.java, v 0.1 2017-12-04 下午10:42 shinnlove.jinsheng Exp $$
 */
public class ReadCSV {

    public static void main(String[] args) {
        String csvPath = "/Users/zhaochensheng/Downloads/10029370_Trade_2015-03-01_2015-03-28.csv";

        File csv = new File(csvPath); // CSV文件路径
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(csv));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> csvLineData = new ArrayList<String>(); // csv数据每一行
        try {
            int lineNum = 0;
            String oneLine = "";
            while ((oneLine = br.readLine()) != null) {

                // 行号数量从1开始
                lineNum++;

                if ("".equals(oneLine)) {
                    // 第四行空行不理会
                    continue;
                }

                // 有内容加入解析数据中
                csvLineData.add(oneLine);

                // 按照微信对账单约定的格式来解析
                if (lineNum == 1) {
                    // 第一行对账单起始日期
                    oneLine = oneLine.replace("#起始日期：", "").replace("终止日期：", ""); // 去掉描述信息
                    String[] dateArray = oneLine.split(" "); // 按照空格切开

                    // 如果数据准确无误（2个日期时分秒，数组长度应该是4）
                    if (dateArray.length == 4) {
                        String startDateStr = dateArray[0].substring(1) + " " + dateArray[1];
                        String endDateStr = dateArray[2] + " " + dateArray[3];

                        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try {
                            Date startDate = simpleFormat.parse(startDateStr);
                            Date endDate = simpleFormat.parse(endDateStr);
                            System.out.println(startDate);
                            System.out.println(endDate);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                } else if (lineNum == 2) {
                    // 第二行对账单总笔数和总金额
                    oneLine = oneLine.replace("#交易金额合计：", "").replace("笔", "").replace("共", "")
                        .replace("元", ""); // 去掉描述信息
                    String[] numberMoneyArray = oneLine.split("，"); // 按照中文逗号切开

                    if (numberMoneyArray.length == 2) {
                        try {
                            int totalCount = Integer.valueOf(numberMoneyArray[0]);
                            double totalMoney = Double.valueOf(formatDouble("0.00").format(
                                Double.valueOf(numberMoneyArray[1])));

                            System.out.println(totalCount);
                            System.out.println(totalMoney);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else if (lineNum == 3) {
                    // 第三行对账单下载日期
                    System.out.println(oneLine);
                } else if (lineNum == 5) {
                    // 从第五行开始是表头
                    String[] titleValueArray = oneLine.split(",");
                    // 打印表头
                    for (int i = 0; i < titleValueArray.length; i++) {
                        System.out.print(titleValueArray[i] + "\t");
                    }
                    System.out.println(); // 换行
                } else if (lineNum > 5) {
                    // 从第六行开始是数据
                    String[] dataValueArray = oneLine.split(",");
                    // 打印数据
                    for (int j = 0; j < dataValueArray.length; j++) {
                        System.out.print(dataValueArray[j] + "\t");
                    }
                    System.out.println(); // 换行
                }

            }
            System.out.println("csv表格中所有行数：" + csvLineData.size());
            System.out.println("csv内容：" + csvLineData.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 格式化double类型数据
     * 
     * @param format
     * @return
     */
    public static DecimalFormat formatDouble(String format) {
        if ("".equals(format)) {
            format = "#";
        }
        return new DecimalFormat(format);
    }

}