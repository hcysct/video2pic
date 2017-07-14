package com.demo.video2pic.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.demo.video2pic.mapper.UserMapper;
import com.demo.video2pic.model.User;
import com.demo.video2pic.service.TestService;

/**
 *
 * 
 */
@Service
public class TestServiceImpl implements TestService {
    private static final Log log = LogFactory.getLog(TestServiceImpl.class);
    @Resource
    private UserMapper userDao;
    
	@Override
	public User queryUserById(Long id) {
		return userDao.queryUserById(id);
	}

	@Override
	public List<User> queryUserListByName(String name) {
		return userDao.queryUserListByName(name);
	}
	@Override
	public void toPng() {
		
	}

	/**
	 * 获取视频信息
	 * 大小
	 * 时间
	 * 分辨率
	 */
	private void getVideoInfo(){
		
	}
	
	private void convertVideoToPic(){
		
	}

}
