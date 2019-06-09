package com.test.student.service;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.Course;

import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
public interface CourseService {
    /**
     * 分页查询用户
     * @param course
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Course> listCourses(Course course, int page, int limit);

    /**
     * 禁用用户
     * @param course
     * @return
     */
    boolean deleteCourse(Course course);

    boolean activeCourse(Course course);

    boolean deleteCourses(List<Course> courses);

    boolean updateCourse(Course course);

    boolean insertCourse(Course course);

    List<Course> listAllCourses();

}
