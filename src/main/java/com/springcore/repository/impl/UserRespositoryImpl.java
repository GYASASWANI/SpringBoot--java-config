package com.springcore.repository.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.springcore.repository.UserRespository;
import com.springcore.vo.UserVO;


public class UserRespositoryImpl implements UserRespository{
// Using collections (userdetails) to store temporarily instead of database
	private Map<Integer, UserVO> userdetails =new HashMap<Integer, UserVO>();
	@Override
	public int addUser(UserVO uservo) {
	
		userdetails.put(uservo.getId(), uservo);
		return 1;
	}

	@Override
	public int removeUser(int userId) {

		UserVO user = userdetails.remove(userId);
		if(ObjectUtils.isEmpty(user))
		return 0;
		
		return 1;
	}

	@Override
	public int updateUser(UserVO uservo) {
		// TODO Auto-generated method stub
		UserVO user = userdetails.get(uservo.getId());
		if(ObjectUtils.isEmpty(user))
			return 0;
		userdetails.put(uservo.getId(), uservo);
		return 1;
	}

	@Override
	public UserVO getUser(int userId) {
	
		return userdetails.get(userId);
	}

	@Override
	public Set<UserVO> getAllUsers() {
	
		return new HashSet<UserVO>(userdetails.values()) ;
	}

}
