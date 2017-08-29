package com.mar.service;

import com.mar.entity.Token;
import com.mar.entity.User;

public interface TokenService {

    /**
     * <p>通过账户密码获取用户Token</p>
     * @param account 登录用户的账户
     * @param password 登录用户密码
     * @return
     */
    Token getByLogin(String account, String password);

    /**
     * 通过token获取到对象用户
     * @param tokenId
     * @return
     */
    User getUserByToken(String tokenId);

    /**
     * <p>销毁失效token</p>
     */
    void destoryToken();

    /**
     * <p>根据tokenId销毁对应token</p>
     * @param tokenId
     */
    void destoryTokenById(String tokenId);
}
