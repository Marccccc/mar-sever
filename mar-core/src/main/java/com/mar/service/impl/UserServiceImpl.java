package com.mar.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mar.dao.UserDao;
import com.mar.entity.User;
import com.mar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> listUser(EntityWrapper entityWrapper) {
        return userDao.selectList(entityWrapper);
    }

    @Override
    @Cacheable(value = "User",key = "'userId'+#userId")
    public User getUser(int userId) {
        return userDao.selectById(userId);
    }


    @Override
    @CachePut(value = "User",key = "'userId'+#result.id")
    public User saveUser(User user) {
        userDao.insert(user);
        return userDao.selectById(user.getId());
    }

    @Override
    @CachePut(value = "User",key = "'userId'+#user.id")
    public User updateUser(User user) {
        userDao.updateById(user);
        return userDao.selectById(user.getId());
    }

    @Override
    public User updateUserPassword(int userId, String currentPassword, String newPassword) {
        return null;
    }

    @Override
    @CacheEvict(value = "User",key = "'userId'+#id")
    public void deleteUser(int userId) {
        userDao.deleteById(userId);
    }

    @Override
    public User userLogin(String account, String password) {
        EntityWrapper<User> entityWrapper=new EntityWrapper<>();
        entityWrapper.eq("account",account).eq("password",password);
        List<User> users=userDao.selectList(entityWrapper);
        if(users.size()!=1){
            throw new RuntimeException("未找到用户");
        }
        return users.get(0);
    }

}
