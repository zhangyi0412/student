package com.test.student.service;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.User;

import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
public interface UserService {
    /**
     * 分页查询用户
     * @param user
     * @param page
     * @param limit
     * @return
     */
    PageInfo<User> listUsers(User user, int page, int limit);

    /**
     * 禁用用户
     * @param user
     * @return
     */
    boolean deleteUser(User user);

    boolean activeUser(User user);

    boolean deleteUsers(List<User> users);

    boolean updateUser(User user);
}
