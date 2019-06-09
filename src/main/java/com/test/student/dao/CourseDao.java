package com.test.student.dao;

import com.test.student.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Mapper
public interface CourseDao {
    /**
     * 查询用户
     * @param course
     * @return
     */
    public List<Course> listCourses(Course course);

    /**
     * 禁用用户
     * @param course
     * @return
     */
    int deleteCourse(Course course);

    int activeCourse(Course course);

    boolean updateCourse(Course course);

    boolean insertCourse(Course course);
}
