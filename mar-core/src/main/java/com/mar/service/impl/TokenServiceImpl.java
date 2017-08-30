package com.mar.service.impl;

import com.mar.dao.TokenDao;
import com.mar.entity.Token;
import com.mar.entity.User;
import com.mar.service.TokenService;
import com.mar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    private @Autowired
    TokenDao tokenDao;
    private @Autowired
    UserService userService;

    @Override
    @CachePut(value = "Token",key = "'tokenId'+#result.id")
    public Token getByLogin(String account, String password) {
        User user=userService.userLogin(account,password);
        Token token=new Token();
        token.setCreateTime(new Date());
        token.setDestroyTime(new Date());
        token.setUserId(user.getId());
        token.setUserName(user.getName());
        token.setValidity(true);
        tokenDao.insert(token);
        return tokenDao.selectById(token.getId());
    }

    @Override
    public User getUserByToken(String tokenId) {
        Token token=tokenDao.selectById(tokenId);
        User user=userService.getUser(token.getUserId());
       // user.setAccount("3");
        //user.setPassword("4");
        return user;
    }

    @Override
    public void destoryToken() {

    }

    @Override
    public void destoryTokenById(String tokenId) {

    }

}
