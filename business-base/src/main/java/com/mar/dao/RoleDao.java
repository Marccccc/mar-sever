package com.mar.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mar.entity.Role;
import com.mar.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Cyc
 * @since 2017-09-08
 */
public interface RoleDao extends BaseMapper<Role> {

    List<User> pageResult(@Param("name") String userName, @Param("companyId") Integer companyId);

    /**
     * 清除用户与角色的关联
     *
     * @param userId
     * @return
     */
    int removeLinkUserRole(Integer userId);

    /**
     * 建立用户与角色的关联
     *
     * @param userId
     * @param roles
     * @return
     */
    int saveLinkUserRole(@Param("userId")Integer userId, @Param("roles")List<Role>roles);

}