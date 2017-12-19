package com.mar.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mar.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao extends BaseMapper<User> {

    /**
     *
     * @param account
     * @return
     */
    User getUser(@Param("account") String account);

    List<User> pageResult(@Param("name") String userName, @Param("companyId") Integer companyId);

}
