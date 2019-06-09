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
    /**
     * 查询用户
     * @param user
     * @return
     */
    public List<User> listUsers(User user);

    /**
     * 禁用用户
     * @param user
     * @return
     */
    int deleteUser(User user);

    int activeUser(User user);

    boolean updateUser(User user);

    boolean insertUser(User user);
}
