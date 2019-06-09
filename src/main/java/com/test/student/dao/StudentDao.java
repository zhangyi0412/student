package com.test.student.dao;

import com.test.student.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Mapper
public interface StudentDao {
    /**
     * 查询用户
     * @param student
     * @return
     */
    public List<Student> listStudents(Student student);

    /**
     * 禁用用户
     * @param student
     * @return
     */
    int deleteStudent(Student student);

    int activeStudent(Student student);

    boolean updateStudent(Student student);

    boolean insertStudent(Student student);
}
