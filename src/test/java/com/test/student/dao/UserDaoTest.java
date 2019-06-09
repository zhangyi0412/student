package com.test.student.dao;

import com.test.student.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Resource
    UserDao userDao;

    @Test
    public void listUsers() {
        User user = new User();
        List<User> users = userDao.listUsers(user);
    }
}