package com.mar.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mar.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface UserDao extends BaseMapper<User>{
    User getUser(@Param("account")String account);
}