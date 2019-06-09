package com.test.student.controller;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.JsonResponse;
import com.test.student.pojo.User;
import com.test.student.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
     *
     * @param user  条件查询参数
     * @param page  页码
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
     *
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
     *
     * @param user
     * @return
     * @throws
     */
    @ResponseBody
    @PostMapping("/active")
    public JsonResponse<Boolean> activeUser(@RequestBody User user) {
        boolean success = userService.activeUser(user);
        if (success) {
            return success("激活成功");
        } else {
            return error("激活失败");
        }
    }

    /**
     * 批量激活
     *
     * @param users
     * @return
     */
    @ResponseBody
    @PostMapping("/deletes")
    public JsonResponse<Boolean> deleteUsers(@RequestBody List<User> users) {
        boolean success = userService.deleteUsers(users);
        if (success) {
            return success("删除成功");
        } else {
            return error("删除失败");
        }
    }

    /**
     * 编辑用户和新增用户，根据用参数是否包含id区分
     *
     * @param user
     * @return
     * @throws
     */
    @ResponseBody
    @PostMapping("/update")
    public JsonResponse<Boolean> updateUser(@RequestBody User user) {
        if (user.getId() != null) {
            boolean success = userService.updateUser(user);
            if (success) {
                return success("修改成功");
            } else {
                return error("修改失败");
            }
        } else {
            // 用户默认密码为电话号码
            user.setPassword(user.getTel());
            boolean success = userService.insertUser(user);
            if (success) {
                return success("新增成功");
            } else {
                return error("新增失败");
            }
        }

    }

    /**
     * 登录
     *
     * @param user
     * @param page
     * @param limit
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public JsonResponse<Boolean> getUsers(@RequestBody User user, HttpSession session) {
        User userNew = userService.getUser(user);
        if (userNew != null) {
            // 保存用用户状态到session
            session.setAttribute("userName", userNew.getUsername());
            session.setAttribute("userId", userNew.getId());
            return success("成功");
        } else {
            return error("失败");
        }
    }

    @ResponseBody
    @PostMapping("/logout")
    public JsonResponse<Boolean> logout(HttpSession session) {
        // 清空session
        session.removeAttribute("userName");
        session.removeAttribute("userId");
        return success("成功");
    }
}