package com.mar.controller;

import com.mar.dto.Response;
import com.mar.entity.Token;
import com.mar.entity.User;
import com.mar.service.TokenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class SessionController {

    @Resource
    TokenService tokenService;

    /**
     * 用户登录验证,成功存入Token
     *
     * @param user 登录用户
     * @return 登录成功的token信息
     */
    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public Response login(@RequestBody @Valid User user) {
        Token token = tokenService.getByLogin(user.getAccount(), user.getPassword());
        return new Response().success(token);
    }

    /**
     * 获取当前session的用户信息
     *
     * @param tokenId 当前token
     * @return 当前用户信息
     */
    @RequestMapping(value = "/session/user", method = RequestMethod.GET)
    public Response getUserBySession(@RequestHeader("Authorization") String tokenId) {
        User user = tokenService.getUserByToken(tokenId);
        return new Response().success(user);
    }

    /**
     * 获取当前session的权限
     *
     * @param tokenId 当前token
     * @return 登录成功的token信息
     */
    @RequestMapping(value = "/session/permissions", method = RequestMethod.GET)
    public Response getPermissionsBySession(@RequestHeader("Authorization") String tokenId) {
        List<String> permissions = tokenService.getPermissionByToken(tokenId);
        return new Response().success(permissions);
    }

    /**
     * 用户登出,删除token
     *
     * @return 登出信息
     */
    @RequestMapping(value = "/session", method = RequestMethod.DELETE)
    public Response logout() {
        return new Response().success();
    }

}
