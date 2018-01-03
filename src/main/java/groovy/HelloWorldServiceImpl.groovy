/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package groovy;

import com.shinnlove.common.service.integration.HelloWorldService;

/**
 * 具体groovy实现类，以.groovy结尾。
 *
 * @author shinnlove.jinsheng
 * @version $Id: HelloWorldServiceImpl.java, v 0.1 2018-01-03 下午2:20 shinnlove.jinsheng Exp $$
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    String name;

    @Override
    public String sayHello() {
        return "Hello $name!!!. Welcome to Scripting in Groovy.";
    }

}