package com.springcore.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.springcore.service.UserService;
import com.springcore.vo.UserVO;


public class UserController {
	@Autowired
	private UserService userservice;//setter injection
	
	public UserController() {
		super();
		System.out.println("Constructor called---------");
		//this.userservice = userservice;
	}
	
	public int addUser(UserVO uservo) {
		return userservice.addUser(uservo);
	}
	public int removeUser(int userId) {
		
		return userservice.removeUser(userId);
	}
	public int updateUser(UserVO uservo) {
		return userservice.updateUser(uservo);
	}
	public UserVO getUser(int userId) {
		return userservice.getUser(userId);
	}
	public Set<UserVO> getAllUsers() {
		return userservice.getAllUsers();
	}

	




}
