package com.demo.video2pic.web;

import java.io.File;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

	@RequestMapping(value = "/test",method=RequestMethod.GET)
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Result result=new Result();
		result.setMsg("生成成功!");
		result.setResultCode(0);
		result.setSuccess(true);
		testService.toPng();
		return JSONObject.fromObject(result).toString();
	}

	@RequestMapping(value = "/index",method=RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/upload";
	}
	@RequestMapping(value = "/uploadfile",method=RequestMethod.POST)
	@ResponseBody
	public String uploadfile(@RequestParam MultipartFile file,HttpServletRequest request) throws Exception {//
		Result result=new Result();
		result.setMsg("生成成功!");
		result.setResultCode(0);
		result.setSuccess(true);
		
		if (!file.isEmpty()) {
            try {
                // 文件存放服务端的位置
                String rootPath = "e:/test";
                File dir = new File(rootPath + File.separator + "tmpFiles");
                if (!dir.exists())
                    dir.mkdirs();
                // 写文件到服务器
                File serverFile = new File(dir.getAbsolutePath() + File.separator + file.getOriginalFilename());
                file.transferTo(serverFile);
                return "You successfully uploaded file=" +  file.getOriginalFilename();
            } catch (Exception e) {
                return "You failed to upload " +  file.getOriginalFilename() + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " +  file.getOriginalFilename() + " because the file was empty.";
        }
		
		
	}
}
