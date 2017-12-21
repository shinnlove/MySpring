/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.util.log;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;

/**
 * 规范化日志打印工具，注意日志的级别选择：<br>
 *
 * <p>
 *   <ol>
 *     <li>DEBUG <b>开发环境</b>应用调试，输出详细的应用状态
 *     <li>INFO <b>生产环境</b>运行状态观察，输出应用生命周期的中<b>正常重要事件</b>
 *     <li>WARN <b>生产环境</b>故障诊断，输出应用中的<b>可预期的异常事件</b>
 *   </ol>
 * </p>
 *
 * <p>注意：ERROR日志记录请使用{@link ExceptionUtil}，避免日志的重复记录</p>
 *
 * @author shinnlove.jinsheng
 * @version $Id: LoggerUtil.java, v 0.1 2017-12-21 下午9:35 shinnlove.jinsheng Exp $$
 */
public class LoggerUtil {

    /** 线程编号修饰符 */
    private static final char   THREAD_RIGHT_TAG    = ']';

    /** 线程编号修饰符 */
    private static final char   THREAD_LEFT_TAG     = '[';

    /** 键值对连接符 */
    private static final String KEY_VALUE_CONNECTOR = "=";

    /** 键值对分隔符 */
    private static final String KEY_VALUE_SEPARATOR = ";";

    /**
     * 禁用构造函数
     */
    private LoggerUtil() {
        // 禁用构造函数
    }

    /**
     * 生成<font color="blue">调试</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void debug(Logger logger, Object... obj) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogString(obj));
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void info(Logger logger, Object... obj) {
        if (logger.isInfoEnabled()) {
            logger.info(getLogString(obj));
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     * 说明： 对比上面的info方法，此方法输出的日志信息更加详细，使用时请注意输出对性能的影响
     *
     * @param logger
     * @param obj
     */
    public static void infoDetail(Logger logger, Object... obj) {
        if (logger.isInfoEnabled()) {
            logger.info(getDetailLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void warn(Logger logger, Object... obj) {
        if (logger.isWarnEnabled()) {
            logger.warn(getLogString(obj));
        }
    }

    /**
     * 生成<font color="brown">警告</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param t
     * @param obj
     */
    public static void warn(Logger logger, Throwable t, Object... obj) {
        if (logger.isWarnEnabled()) {
            logger.warn(getLogString(obj), t);
        }
    }

    /**
     * 生成输出到日志的字符串
     *
     * @param obj 任意个要输出到日志的参数
     * @return
     */
    public static String getLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId()).append(THREAD_RIGHT_TAG);
        for (Object o : obj) {
            log.append(o);
        }
        return log.toString();
    }

    /**
     * 生成输出到日志的字符串(对比getLogString，本方法会详细输出List,map等指定集合信息)
     *
     * @param obj 任意个要输出到日志的参数
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getDetailLogString(Object... obj) {
        StringBuilder log = new StringBuilder();
        log.append(THREAD_LEFT_TAG).append(Thread.currentThread().getId()).append(THREAD_RIGHT_TAG);
        for (Object o : obj) {
            if (o instanceof Map) {
                log.append(objectMap2string((Map) o));
            } else if (o instanceof String) {
                log.append((String) o);
            } else if (o instanceof List) {
                log.append(objectList2String((List) o));
            } else {
                log.append(ToStringBuilder.reflectionToString(o));
            }
            log.append(KEY_VALUE_SEPARATOR);
        }
        return log.toString();
    }

    /**
     * List对象转成String
     *
     * @param list
     * @return
     */
    private static String objectList2String(List<Object> list) {
        if (null == list) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (Object obj : list) {
            sb.append(ToStringBuilder.reflectionToString(obj));
            sb.append(KEY_VALUE_SEPARATOR);
        }
        return sb.toString();
    }

    /**
     * Map对象转成String
     *
     * @param map
     * @return
     */
    private static String objectMap2string(Map<String, Object> map) {
        if (null == map) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        for (String key : map.keySet()) {

            // 处理空字符串
            String str = String.valueOf(map.get(key));
            if (str == null || "".equals(str)) {
                str = "";
            }

            sb.append(key);
            sb.append(KEY_VALUE_CONNECTOR);
            sb.append(str);
            sb.append(KEY_VALUE_SEPARATOR);
        }
        return sb.toString();
    }

}