package com.test.student.dao;

import com.test.student.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Mapper
public interface UserDao {
    public List<User> listUsers(User user);
}
