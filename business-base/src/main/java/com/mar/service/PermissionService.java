package com.mar.service;

import com.mar.dao.PermissionDao;
import com.mar.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PermissionService {

    /**
     * 关联角色与权限
     *
     * @param roleId      待关联的角色ID
     * @param permissions 待关联的权限列表
     */
    void linkRolePermissions(Integer roleId, List<Permission> permissions);

    /**
     * 通过角色获取权限
     *
     * @param roleId 获取权限的角色ID
     * @return 权限列表
     */
    List<Permission> getPermissionsByRole(String roleId);

    /**
     * 通过用户获取权限
     *
     * @param userId 获取权限的用户ID
     * @return 权限列表
     */
    List<Permission> getPermissionsByUser(Integer userId);

}
