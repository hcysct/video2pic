package com.demo.video2pic.service;

import java.util.List;

import com.demo.video2pic.model.User;

/**
 */
public interface TestService {
	public User queryUserById(Long id);
	public List<User> queryUserListByName(String name);

	/**
	 * 视频转换为图片
	 */
	public void toPng();
}
