package com.mar.service.impl;

import com.mar.dao.TokenDao;
import com.mar.entity.Permission;
import com.mar.entity.Token;
import com.mar.entity.User;
import com.mar.service.PermissionService;
import com.mar.service.TokenService;
import com.mar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class TokenServiceImpl implements TokenService {

    private @Autowired TokenDao tokenDao;
    private @Autowired UserService userService;
    private @Autowired PermissionService permissionService;

    @Override
    @CachePut(value = "Token",key = "'tokenId'+#result.id")
    public Token getByLogin(String account, String password) {
        User user=userService.login(account,password);
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
        return userService.getUser(token.getUserId());
    }

    @Override
    public List<String> getPermissionByToken(String tokenId) {
        Token token=tokenDao.selectById(tokenId);
        List<Permission> permissions=permissionService.getPermissionsByUser(token.getUserId());
        List<String> permissionCodes= new LinkedList<>();
        permissions.forEach(permission -> permissionCodes.add(permission.getCode()));
        return permissionCodes;
    }

    @Override
    public void destoryToken() {

    }

    @Override
    public void destoryTokenById(String tokenId) {

    }

}
