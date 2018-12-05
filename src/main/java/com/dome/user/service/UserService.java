package com.dome.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dome.user.entity.User;
import com.dome.user.mapper.UserMapper;

@Service("userService")
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
}