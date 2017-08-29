package com.mar.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mar.entity.User;

import java.util.List;

/**
 * <p>用户服务</p>
 * @author CC
 */
public interface UserService {

	/**
	 * <p>获取用户列表</p>
	 * @param entityWrapper 查询条件构造参数
	 * @return
	 */
	List<User> listUser(EntityWrapper entityWrapper);

	/**
	 * <p>获取单个用户信息</p>
	 * @param userId 用户ID
	 * @return user 返回用户信息
	 */
	User getUser(int userId);

	/**
	 * <p>创建用户</p>
	 * @return user 返回用户信息
	 */
	User saveUser(User user);

	/**
	 * <p>更新用户</p>
	 * @param user 新用户信息
	 */
	User updateUser(User user);

	/**
	 * <p>更新用户密码</p>
	 * @param userId 用户ID
	 * @param currentPassword 当前密码
	 * @param newPassword 新密码
	 * @return user 返回的简要用户信息
	 */
	User updateUserPassword(int userId, String currentPassword, String newPassword);

	/**
	 * <p>删除用户</p>
	 * @param userId 用户ID
	 * @return User 返回的简要用户信息
	 */
	void deleteUser(int userId);

    /**
     * 通过账户密码获取用户
     * @param account
     * @param password 加密后的密码
     * @return
     */
	User userLogin(String account, String password);

}
