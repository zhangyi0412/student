package com.test.student.controller;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.JsonResponse;
import com.test.student.pojo.User;
import com.test.student.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    @Resource
    UserService userService;

    /**
     * 分页查询用户
     * @param user 条件查询参数
     * @param page 页码
     * @param limit 页大小
     * @return
     */
    @ResponseBody
    @GetMapping("/listUsers")
    public JsonResponse<List<User>> listUsers(User user, @RequestParam(name = "page", defaultValue = "1") int page,
                                             @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageInfo<User> pageInfo = userService.listUsers(user, page, limit);
        return success(pageInfo.getList(), pageInfo.getTotal());
    }

    /**
     * 禁用用户
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/delete")
    public JsonResponse<Boolean> deleteUser(@RequestBody User user) {
        boolean success = userService.deleteUser(user);
        if (success) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }

    /**
     * 激活用户
     * @param user
     * @return
     * @throws
     */
    @ResponseBody
    @PostMapping("/active")
    public JsonResponse<Boolean> activeUser(@RequestBody User user)   {
        boolean success = userService.activeUser(user);
        if (success) {
            return success("激活成功");
        } else {
            return error("激活失败");
        }
    }

    /**
     * 批量激活
     * @param users
     * @return
     */
    @ResponseBody
    @PostMapping("/deletes")
    public JsonResponse<Boolean> deleteUsers(@RequestBody List<User> users){
        boolean success = userService.deleteUsers(users);
        if (success) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }
}