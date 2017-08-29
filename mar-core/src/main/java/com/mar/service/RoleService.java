package com.mar.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mar.entity.Role;

import java.util.List;

/**
 * 角色服务
 */
public interface RoleService {

    /**
     * 获取角色列表
     * @param entityWrapper
     * @returns
     */

    /**
     * 获取角色
     * @param roleId
     * @return
     */
    Role getRole(int roleId);

    /**
     * 删除角色
     * @param roleId
     */
    void removeRole(int roleId);

    /**
     * 更新角色
     * @param role
     * @return
     */
    Role updateRole(Role role);

    /**
     * 保存角色
     * @param role
     * @return
     */
    Role saveRole(Role role);

}
