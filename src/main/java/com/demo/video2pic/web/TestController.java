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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.video2pic.bean.Result;
import com.demo.video2pic.service.TestService;

import net.sf.json.JSONObject;

@Controller
public class TestController {
	private static final Log log = LogFactory.getLog(TestController.class);
    @Resource(name="redisTemplate")
    private ListOperations<String, String> listOps;
	@Resource
	private TestService testService;

	@RequestMapping(value = "/test.do",method=RequestMethod.GET)
	@ResponseBody
	public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result=new Result();
		result.setMsg("生成成功!");
		result.setResultCode(0);
		result.setSuccess(true);
		testService.toPng();
		return JSONObject.fromObject(result).toString();
	}

}
