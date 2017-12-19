package com.mar.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.mar.dto.Page;
import com.mar.entity.Role;
import com.mar.entity.User;

import java.util.List;

/**
 * <p>用户服务</p>
 *
 * @author CC
 */
public interface UserService extends IService<User> {

    /**
     * 分页查询用户信息
     *
     * @param page 分页信息
     */
    void loadPageResult(Page page);

    /**
     * 获取单个用户信息
     *
     * @param userId 用户ID
     * @return user 返回用户信息
     */
    User getUser(int userId);

    /**
     * <p>创建用户</p>
     *
     * @return user 返回用户信息
     */
    void save(User user);

    /**
     * <p>更新用户</p>
     *
     * @param user 新用户信息
     */
    void update(User user);

    /**
     * <p>更新用户密码</p>
     *
     * @param userId          用户ID
     * @param currentPassword 当前密码
     * @param newPassword     新密码
     * @return user 返回的简要用户信息
     */
    User updatePassword(int userId, String currentPassword, String newPassword);

    /**
     * <p>删除用户</p>
     *
     * @param userId 用户ID
     * @return User 返回的简要用户信息
     */
    void delete(int userId);

    /**
     * 通过账户密码获取用户
     *
     * @param account
     * @param password 加密后的密码
     * @return
     */
    User login(String account, String password);

}
