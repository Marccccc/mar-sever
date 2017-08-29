package com.mar.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mar.dao.UserDao;
import com.mar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private @Autowired
    UserDao userDao;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public List<User> test(){
        return userDao.selectList(new EntityWrapper<User>());
    }

}
