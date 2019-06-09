package com.test.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.student.dao.CourseDao;
import com.test.student.pojo.Course;
import com.test.student.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    CourseDao courseDao;

    @Override
    public PageInfo<Course> listCourses(Course course, int page, int limit) {
        //开启分页查询，写在查询语句上方
        PageHelper.startPage(page, limit);
        // 查询所有的用户
        List<Course> courses = courseDao.listCourses(course);
        // 注意这里的泛型
        PageInfo<Course> pageInfo = new PageInfo<>(courses);
        // 返回分页信息
        return pageInfo;
    }

    @Override
    public boolean deleteCourse(Course course) {
        int count = 0;
        count = courseDao.deleteCourse(course);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean activeCourse(Course course) {
        int count = 0;
        count = courseDao.activeCourse(course);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteCourses(List<Course> courses) {
        int count = 0;
        for (Course course : courses) {
            if (deleteCourse(course)) {
                count++;
            }
        }
        if (count == courses.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateCourse(Course course) {
        boolean success = false;
        success = courseDao.updateCourse(course);
        return success;
    }

    @Override
    public boolean insertCourse(Course course) {
        return courseDao.insertCourse(course);
    }
}
