package com.mar.controller;

import com.baomidou.mybatisplus.mapper.Condition;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mar.dto.Page;
import com.mar.dto.Response;
import com.mar.entity.Token;
import com.mar.entity.User;
import com.mar.service.TokenService;
import com.mar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     *
     * @param page 分页查询信息
     * @return 查询结果
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Response getUsers(Page<User> page) {
        userService.loadPageResult(page);
        return new Response().success(page);
    }

    /**
     * 用户新增
     *
     * @param user 待新增用户
     * @return 成功信息
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Response saveUser(@RequestBody @Valid User user) {
        try {
            userService.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Response().success();
    }

    /**
     * 用户更新
     *
     * @param user 待更新用户
     * @return 成功信息
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PATCH)
    public Response patchUser(@PathVariable("userId")String userId,@RequestBody @Valid User user) {
        userService.update(user);
        return new Response().success();
    }

    /**
     * 用户更改状态
     *
     * @param userId 待更改状态的userId
     * @param user 待更改的用户
     * @return 成功信息
     */
    @RequestMapping(value = "/user/{userId}/status", method = RequestMethod.PUT)
    public Response changeStatus(@PathVariable Integer userId, @RequestBody User user) {
        User updateUser=new User();
        updateUser.setId(user.getId());
        updateUser.setStatus(user.isStatus());
        userService.update(user);
        return new Response().success();
    }

    /**
     * 获取用户
     *
     * @param userId 待获取信息的用户ID
     * @return 成功信息
     */
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public Response getUser(@PathVariable Integer userId) {
        return new Response().success(userService.getUser(userId));
    }

}
