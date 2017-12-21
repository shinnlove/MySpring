/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.log;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 捕捉到异常的时候，我们通常会使用<code>logger.error("xxxx",e)</code>方式打印日常堆栈日志<br>
 * 但是这种方式会造成错误日志打印两遍，精益求精，日志也追求极致，本系统的错误日志全部使用本工具类输出
 *
 * @author shinnlove.jinsheng
 * @version $Id: ExceptionUtil.java, v 0.1 2017-12-21 下午9:48 shinnlove.jinsheng Exp $$
 */
public class ExceptionUtil {

    /** logger */
    private static final Logger logger                            = LoggerFactory
                                                                      .getLogger("com.shinnlove");

    /** logger */
    private static final Logger alertLogger                       = LoggerFactory
                                                                      .getLogger("COMMON-ALERT");

    /** logger*/
    private static final Logger errorDigestLogger                 = LoggerFactory
                                                                      .getLogger("ERROR-DIGEST");

    /** 根异常分隔符 */
    private static final String ROOT_CAUSE_SEPARATOR              = "@";

    /** 根异常类方法分割符 */
    private static final String ROOT_CAUSE_CLASS_METHOD_SEPARATOR = ".";

    /**空字符窜*/
    private static final String NONE                              = "-";

    /**
     * 禁用构造函数
     */
    private ExceptionUtil() {
        // 禁用构造函数
    }

    /**
     * 捕捉错误日志并输出到日志文件：common-error.log
     *
     * @param e 异常堆栈
     * @param message 错误日志上下文信息描述，尽量带上业务特征
     */
    public static void error(Throwable e, Object... message) {
        logger.error(LoggerUtil.getLogString(message), e);
        printErrorDigest(e);
    }

    private static void printErrorDigest(Throwable e) {
        //        try {
        //            HostInfo hostInfo = SystemUtil.getHostInfo();
        //            if (null == hostInfo) {
        //                return;
        //            }
        //            String hostName = hostInfo.getName();
        //            String[] appNameArr = StringUtil.split(hostName, "-");
        //            if (appNameArr == null || appNameArr.length == 0) {
        //                return;
        //            }
        //            if (ErrorDigestSwitchUtil.isSwitchOn(appNameArr[0])) {
        //                Throwable rootCause = fetchRootCause(e);
        //                errorDigestLogger.warn(LoadTestUtil.isLoadTestMode() + "##"
        //                                       + getRootCause(rootCause) + "##"
        //                                       + getRootDescribe(rootCause));
        //            }
        //
        //        } catch (Exception logException) {
        //            logger.error("打印错误摘要日志异常", logException.getCause());
        //        }

    }

    /**
     * 捕捉错误日志并输出到日志文件：common-error.log
     *
     * @param message 错误日志上下文信息描述，尽量带上业务特征
     */
    public static void error(Object... message) {
        logger.error(LoggerUtil.getLogString(message));
    }

    /**
     * 捕捉错误日志并输出到日志文件：common-error.log
     *
     * @param message 错误日志上下文信息描述，尽量带上业务特征
     * 说明：对比error，此方法信息更加详细，请使用前确认下输出的日志信息对性能的影响
     */
    public static void errorDetail(Object... message) {
        logger.error(LoggerUtil.getDetailLogString(message));
    }

    /**
     * 捕捉错误日志并输出到日志文件：alert.de.log
     *
     * @param e 异常堆栈
     * @param message 错误日志上下文信息描述，尽量带上业务特征
     */
    public static void alert(Throwable e, Object... message) {
        alertLogger.error(LoggerUtil.getLogString(message), e);
    }

    /**
     * 捕捉错误日志并输出到日志文件：alert.de.log
     *
     * @param message 错误日志上下文信息描述，尽量带上业务特征
     */
    public static void alert(Object... message) {
        alertLogger.error(LoggerUtil.getLogString(message));
    }

    public static Throwable fetchRootCause(Throwable e) {
        if (e == null) {
            return null;
        }
        // 防环处理,迭代异常链,防止死循环,最大循环5次
        Set<Throwable> visited = new HashSet<Throwable>();
        Throwable rootCause = null;
        Throwable p = e;
        for (int i = 0; p != null && !visited.contains(p) && i < 5; p = p.getCause()) {
            // 标记异常链当前位置已被访问
            visited.add(p);
            //最后取最顶端的错误cause
            rootCause = p;
            i++;
        }
        return rootCause;
    }

    /**
     * 获取当前异常的描述
     * 必须先调用 fetchDescribe
     * @return
     */
    public static String getRootDescribe(Throwable cause) {
        String msg = cause.getMessage();
        if (msg != null && !"".equals(msg)) {
            // 清除系统原生异常中可能带有的换行符
            msg.replace('\n', ' ').replace('\r', ' ').replace('#', ' ');
        } else {
            msg = NONE;
        }
        return msg;
    }

    /**
     * 获取根异常
     * 必须先调用 fetchDescribe
     * @return
     */
    public static String getRootCause(Throwable root) {
        if (root == null) {
            return NONE + ROOT_CAUSE_SEPARATOR + NONE + ROOT_CAUSE_CLASS_METHOD_SEPARATOR + NONE;
        }

        StringBuilder ret = new StringBuilder();
        ret.append(root.getClass().getSimpleName());

        // 获取根错误堆栈
        StackTraceElement trace[] = root.getStackTrace();
        if (trace != null && trace.length > 0) {
            StackTraceElement traceTop = trace[0];

            // 简化className
            String className = traceTop.getClassName();
            className = className.substring(className.lastIndexOf('.') + 1);

            ret.append(ROOT_CAUSE_SEPARATOR);
            ret.append(className);
            ret.append(ROOT_CAUSE_CLASS_METHOD_SEPARATOR);
            ret.append(traceTop.getMethodName());
        }

        return ret.toString();
    }

}