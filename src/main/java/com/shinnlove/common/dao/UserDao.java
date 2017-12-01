/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.shinnlove.common.dao;

import com.shinnlove.common.model.User;

/**
 * @author shinnlove.jinsheng
 * @version $Id: UserDao.java, v 0.1 2017-11-25 下午10:39 shinnlove.jinsheng Exp $$
 */
public interface UserDao {

    User getUserById(int id);

}