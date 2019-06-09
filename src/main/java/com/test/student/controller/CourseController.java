package com.test.student.controller;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.JsonResponse;
import com.test.student.pojo.Course;
import com.test.student.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Controller
@RequestMapping("/course")
public class CourseController extends BaseController {
    @Resource
    CourseService courseService;

    /**
     * 分页查询用户
     * @param course 条件查询参数
     * @param page 页码
     * @param limit 页大小
     * @return
     */
    @ResponseBody
    @GetMapping("/listCourses")
    public JsonResponse<List<Course>> listCourses(Course course, @RequestParam(name = "page", defaultValue = "1") int page,
                                             @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageInfo<Course> pageInfo = courseService.listCourses(course, page, limit);
        return success(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 禁用用户
     * @param course
     * @return
     */
    @ResponseBody
    @PostMapping("/delete")
    public JsonResponse<Boolean> deleteCourse(@RequestBody Course course) {
        boolean success = courseService.deleteCourse(course);
        if (success) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }

    /**
     * 激活用户
     * @param course
     * @return
     * @throws
     */
    @ResponseBody
    @PostMapping("/active")
    public JsonResponse<Boolean> activeCourse(@RequestBody Course course)   {
        boolean success = courseService.activeCourse(course);
        if (success) {
            return success("激活成功");
        } else {
            return error("激活失败");
        }
    }

    /**
     * 批量激活
     * @param courses
     * @return
     */
    @ResponseBody
    @PostMapping("/deletes")
    public JsonResponse<Boolean> deleteCourses(@RequestBody List<Course> courses){
        boolean success = courseService.deleteCourses(courses);
        if (success) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }

    /**
     * 编辑用户和新增用户，根据用参数是否包含id区分
     * @param course
     * @return
     * @throws
     */
    @ResponseBody
    @PostMapping("/update")
    public JsonResponse<Boolean> updateCourse(@RequestBody  Course course){
        if(course.getId()!=null){
            boolean success = courseService.updateCourse(course);
            if (success) {
                return success("修改成功");
            } else {
                return error("修改失败");
            }
        }else {
            boolean success = courseService.insertCourse(course);
            if (success) {
                return success("新增成功");
            } else {
                return error("新增失败");
            }
        }

    }
}