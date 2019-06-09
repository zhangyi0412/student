package com.test.student.service;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.Student;

import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
public interface StudentService {
    /**
     * 分页查询用户
     * @param student
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Student> listStudents(Student student, int page, int limit);

    /**
     * 禁用用户
     * @param student
     * @return
     */
    boolean deleteStudent(Student student);

    boolean activeStudent(Student student);

    boolean deleteStudents(List<Student> students);

    boolean updateStudent(Student student);

    boolean insertStudent(Student student);

    List<Student> listAllStudents();
}
