package com.mar.service;

import com.baomidou.mybatisplus.service.IService;
import com.mar.dto.Page;
import com.mar.entity.Role;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Cyc
 * @since 2017-09-08
 */
public interface RoleService extends IService<Role> {

    /**
     * 分页查询用户信息
     *
     * @param page 分页信息
     */
    void loadPageResult(Page page);

    /**
     * 新增角色
     *
     * @param role 待新增角色
     */
    void save(Role role);

    /**
     * 更新角色
     *
     * @param role 待删除角色
     */
    void update(Role role);

    /**
     * 删除角色
     *
     * @param roleId 待删除的角色ID
     */
    void delete(Integer roleId);

    /**
     * 关联用户的角色
     *
     * @param userId 用户ID
     */
    void linkUserRole(int userId, List<Role> roles);

}
