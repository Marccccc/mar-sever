package com.mar.controller;

import com.mar.dto.Response;
import com.mar.entity.Role;
import com.mar.entity.User;
import com.mar.service.RoleService;
import com.mar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class RoleController {
	
	@Autowired
	RoleService roleService;

	/**
	 * 角色新增
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/role",method= RequestMethod.POST)
	public Response saveRole(@RequestBody @Valid Role role){
		roleService.insert(role);
		return new Response().success();
	}

    /**
     * 角色修改
     * @param role
     * @return
     */
    @RequestMapping(value = "/role/{roleId}",method= RequestMethod.PATCH)
    public Response patchUser(@RequestBody @Valid Role role){
		roleService.updateById(role);
        return new Response().success();
    }

	/**
	 * 角色删除
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/user/{userId}/status",method= RequestMethod.DELETE)
	public Response logout(@PathVariable Integer roleId){
		roleService.deleteById(roleId);
		return new Response().success();
	}

}
