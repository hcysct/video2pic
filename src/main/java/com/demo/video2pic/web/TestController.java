package com.demo.video2pic.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	private static final Log log = LogFactory.getLog(TestController.class);
    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;

	@RequestMapping(value = "/test.do")
	public String detail(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) throws Exception {
		return "test";
	}

}
