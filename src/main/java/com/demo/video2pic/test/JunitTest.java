package com.demo.video2pic.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.video2pic.service.TestService;

/**
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml","classpath:config/dispatcher-servlet.xml"} )  
public class JunitTest {
	private final String CONTENT_KEY = "para";

	@Resource
	private TestService testService;
	/**
	 * 
	 */
	@Test
	public void queryGroupFamily() {
		testService.toPng();
		System.out.println("1223");
	}
	
}
