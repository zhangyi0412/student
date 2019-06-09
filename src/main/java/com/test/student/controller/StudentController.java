package com.test.student.controller;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.JsonResponse;
import com.test.student.pojo.Student;
import com.test.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Controller
@RequestMapping("/student")
public class StudentController extends BaseController {
    @Resource
    StudentService studentService;

    /**
     * 分页查询用户
     * @param student 条件查询参数
     * @param page 页码
     * @param limit 页大小
     * @return
     */
    @ResponseBody
    @GetMapping("/listStudents")
    public JsonResponse<List<Student>> listStudents(Student student, @RequestParam(name = "page", defaultValue = "1") int page,
                                             @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageInfo<Student> pageInfo = studentService.listStudents(student, page, limit);
        return success(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 禁用用户
     * @param student
     * @return
     */
    @ResponseBody
    @PostMapping("/delete")
    public JsonResponse<Boolean> deleteStudent(@RequestBody Student student) {
        boolean success = studentService.deleteStudent(student);
        if (success) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }

    /**
     * 激活用户
     * @param student
     * @return
     * @throws
     */
    @ResponseBody
    @PostMapping("/active")
    public JsonResponse<Boolean> activeStudent(@RequestBody Student student)   {
        boolean success = studentService.activeStudent(student);
        if (success) {
            return success("激活成功");
        } else {
            return error("激活失败");
        }
    }

    /**
     * 批量激活
     * @param students
     * @return
     */
    @ResponseBody
    @PostMapping("/deletes")
    public JsonResponse<Boolean> deleteStudents(@RequestBody List<Student> students){
        boolean success = studentService.deleteStudents(students);
        if (success) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }

    /**
     * 编辑用户和新增用户，根据用参数是否包含id区分
     * @param student
     * @return
     * @throws
     */
    @ResponseBody
    @PostMapping("/update")
    public JsonResponse<Boolean> updateStudent(@RequestBody  Student student){
        if(student.getId()!=null){
            boolean success = studentService.updateStudent(student);
            if (success) {
                return success("修改成功");
            } else {
                return error("修改失败");
            }
        }else {
            boolean success = studentService.insertStudent(student);
            if (success) {
                return success("新增成功");
            } else {
                return error("新增失败");
            }
        }

    }
}