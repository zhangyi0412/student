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

    @Override
    public boolean deleteUser(User user) {
        int count = 0;
        count = userDao.deleteUser(user);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean activeUser(User user) {
        int count = 0;
        count = userDao.activeUser(user);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUsers(List<User> users) {
        int count = 0;
        for (User user : users) {
            if (deleteUser(user)) {
                count++;
            }
        }
        if (count == users.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        boolean success = false;
        success = userDao.updateUser(user);
        return success;
    }

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }
}
