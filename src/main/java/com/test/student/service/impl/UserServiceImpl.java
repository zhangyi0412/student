package com.test.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.student.dao.UserDao;
import com.test.student.pojo.User;
import com.test.student.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;

    @Override
    public PageInfo<User> listUsers(User user, int page, int limit) {
        //开启分页查询，写在查询语句上方
        PageHelper.startPage(page, limit);
        // 查询所有的用户
        List<User> users = userDao.listUsers(user);
        // 注意这里的泛型
        PageInfo<User> pageInfo = new PageInfo<>(users);
        // 返回分页信息
        return pageInfo;
    }
}
