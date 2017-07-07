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
 * 微信关联平台活动业务方法
 *
 * Created by zyh on 2015/11/30.
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
}
