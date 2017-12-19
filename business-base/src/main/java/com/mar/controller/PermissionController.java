package com.mar.controller;

import com.mar.dto.Response;
import com.mar.entity.Permission;
import com.mar.service.PermissionService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    /**
     * 获取用户权限
     *
     * @param userId 用户ID
     * @return 用户权限列表
     */
    @RequestMapping(value = "/user/{userId}/permissions", method = RequestMethod.GET)
    public Response getPermissionsByUser(@PathVariable Integer userId) {
        return new Response().success(permissionService.getPermissionsByUser(userId));
    }

    /**
     * 关联用户权限
     *
     * @param permissions 赋予用户的权限
     * @param userId      需要关联的用户权限
     * @return 成功信息
     */
    @RequestMapping(value = "/user/{userId}/permissions", method = RequestMethod.PUT)
    public Response linksUserPermissions(@RequestBody @Valid List<Permission> permissions, @PathVariable String userId) {
        return new Response().success();
    }

}
