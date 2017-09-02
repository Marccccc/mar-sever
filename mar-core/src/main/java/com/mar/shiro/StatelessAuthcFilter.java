package com.mar.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mar.dto.Response;
import com.mar.exception.AuthorException;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StatelessAuthcFilter extends AccessControlFilter {

    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        //1、客户端生成的消息摘要
        String clientDigest = "hash";//加密摘要
        //2、客户端传入的用户身份

        String token= httpRequest.getHeader(Constants.AUTHOR);

        //4、生成无状态Token
        StatelessToken statelessToken = new StatelessToken(token,clientDigest);
        try {
            //5、委托给Realm进行登录
            getSubject(request, response).login(statelessToken);
        } catch (Exception e) {
            e.printStackTrace();
            onLoginFail(response);
            return false;
        }
        return true;
    }
    //登录失败时默认返回401状态码
    private void onLoginFail(ServletResponse response) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.setHeader("Content-Type", "application/json;charset=utf-8");
        httpResponse.getWriter().write(new ObjectMapper().writeValueAsString(new Response().failure("无效的token信息")));
    }
}