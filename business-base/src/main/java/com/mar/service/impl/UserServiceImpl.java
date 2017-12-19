package com.mar.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mar.dao.UserDao;
import com.mar.dto.Page;
import com.mar.entity.User;
import com.mar.service.RoleService;
import com.mar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoleService roleService;

    @Override
    public void loadPageResult(Page page) {
        PageHelper.startPage(page.getCurrent(), page.getSize());
        List<User> users = userDao.pageResult((String) page.getConditions().get("name"), page.getConditions().get("companyId")!=null?new Integer(page.getConditions().get("companyId").toString()):null);
        page.setRecords(users);
        page.setTotal((new PageInfo(users)).getTotal());
    }

    @Override
    @Cacheable(value = "User", key = "'userId'+#userId")
    public User getUser(int userId) {
        return userDao.selectById(userId);
    }

    @Override
    @CachePut(value = "User", key = "'userId'+#result.id")
    @Transactional
    public void save(User user) {
        userDao.insert(user);
        roleService.linkUserRole(user.getId(), user.getRoles());
    }

    @Override
    @CachePut(value = "User", key = "'userId'+#user.id")
    @Transactional
    public void update(User user) {
        userDao.updateById(user);
        roleService.linkUserRole(user.getId(), user.getRoles());
    }

    @Override
    public User updatePassword(int userId, String currentPassword, String newPassword) {
        return null;
    }

    @Override
    @CacheEvict(value = "User", key = "'userId'+#id")
    public void delete(int userId) {
        userDao.deleteById(userId);
        roleService.linkUserRole(userId, new LinkedList<>());
    }

    @Override
    public User login(String account, String password) {
        EntityWrapper<User> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("account", account).eq("password", password);
        List<User> users = userDao.selectList(entityWrapper);
        if (users.size() != 1) {
            throw new RuntimeException("未找到用户");
        }
        return users.get(0);
    }
}
