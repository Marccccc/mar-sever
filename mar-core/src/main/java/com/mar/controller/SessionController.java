package com.mar.controller;

import com.mar.dto.Response;
import com.mar.entity.Token;
import com.mar.entity.User;
import com.mar.service.TokenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class SessionController {
	
	@Resource
	TokenService tokenService;

	/**
	 * 用户登录验证,成功存入Token
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/session",method= RequestMethod.POST)
	public Response login(@RequestBody User user){
        Token token=tokenService.getByLogin(user.getAccount(),user.getPassword());
		Response reponse=new Response().success(token);
		return reponse;

	}

	/**
	 * 验证失败,跳转到登录页面
	 * @return
	 */
	@RequestMapping(value="/fail",method= RequestMethod.GET)
	public Response noFindSession(){
		Response response=new Response().failure("登录失败");
		return response;
	}

	/**
	 * 用户登出,删除token
	 * @param tokenId
	 * @return
	 */
	@RequestMapping(value = "/session",method= RequestMethod.DELETE)
	public Response logout(@PathVariable String tokenId){
		tokenService.destoryTokenById(tokenId);
		Response reponse=new Response().success();
		return reponse;
	}

}
