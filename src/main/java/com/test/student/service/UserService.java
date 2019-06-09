package com.test.student.service;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.User;

/**
 * @author admin
 * @date 2019/6/9
 */
public interface UserService {
    PageInfo<User> listUsers(User user, int page, int limit);
}
