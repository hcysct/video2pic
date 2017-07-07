package com.demo.video2pic.mapper;

import java.util.List;

import com.demo.video2pic.model.User;

public interface UserMapper {
	public User queryUserById(Long id);
	public List<User> queryUserListByName(String name);
	
}
