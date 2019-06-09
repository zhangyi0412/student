package com.test.student.controller;

import com.github.pagehelper.PageInfo;
import com.test.student.pojo.JsonResponse;
import com.test.student.pojo.User;
import com.test.student.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @date 2019/6/9
 */
@Controller
public class UserController extends BaseController {
    @Resource
    UserService userService;

    @ResponseBody
    @GetMapping("/listUsers")
    public JsonResponse<List<User>> listUsers(User user, @RequestParam(name = "page", defaultValue = "1") int page,
                                             @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PageInfo<User> pageInfo = userService.listUsers(user, page, limit);
        return success(pageInfo.getList(), pageInfo.getTotal());
    }
}