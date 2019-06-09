package com.test.student.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.student.dao.StudentDao;
import com.test.student.pojo.Student;
import com.test.student.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentDao studentDao;

    @Override
    public PageInfo<Student> listStudents(Student student, int page, int limit) {
        //开启分页查询，写在查询语句上方
        PageHelper.startPage(page, limit);
        // 查询所有的用户
        List<Student> students = studentDao.listStudents(student);
        // 注意这里的泛型
        PageInfo<Student> pageInfo = new PageInfo<>(students);
        // 返回分页信息
        return pageInfo;
    }

    @Override
    public boolean deleteStudent(Student student) {
        int count = 0;
        count = studentDao.deleteStudent(student);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean activeStudent(Student student) {
        int count = 0;
        count = studentDao.activeStudent(student);
        if (count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStudents(List<Student> students) {
        int count = 0;
        for (Student student : students) {
            if (deleteStudent(student)) {
                count++;
            }
        }
        if (count == students.size()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean success = false;
        success = studentDao.updateStudent(student);
        return success;
    }

    @Override
    public boolean insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> listAllStudents() {
        Student student = new Student();
        // 查询所有的用户
        List<Student> students = studentDao.listStudents(student);
        return students;
    }
}
