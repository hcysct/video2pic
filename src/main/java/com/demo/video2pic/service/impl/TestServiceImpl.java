package com.demo.video2pic.service.impl;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.demo.video2pic.mapper.UserMapper;
import com.demo.video2pic.model.User;
import com.demo.video2pic.service.TestService;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;

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
		//测试数据 windows
//		String sourcePath="D:\\test\\gee_0.mp4";
//		String targetOriginPath="D:\\test\\gee_";//默认图片名称
		//linux 
		String sourcePath="/webapp/gee1.mp4";
		String targetOriginPath="/webapp/test/gee_";//默认图片名称
		String targetStyle="png";
		File source = new File(sourcePath);//原始视频地址
		Encoder encoder = new Encoder();//转码工具类
		VideoAttributes video = new VideoAttributes();
		MultimediaInfo mi;
		int videoTime=0;
		try {
			long beginTime = System.currentTimeMillis();
			mi = encoder.getInfo(source);
			//获取时长
			 System.out.println("获取时长花费时间是：" + (System.currentTimeMillis() - beginTime));
			videoTime=(int) (mi.getDuration()/1000);
			//获取视频分辨率
			int width=mi.getVideo().getSize().getWidth();//宽
			int height=mi.getVideo().getSize().getHeight();//高
			video.setCodec(targetStyle);//转图片格式
			video.setSize(new VideoSize(width, height));//调整图片生成的分辨率
			System.out.println(mi.getDuration());
		} catch (InputFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (EncoderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i=1;i<videoTime;i++){//i为初始位置 （秒数） 每秒一张
			EncodingAttributes attrs = new EncodingAttributes();
			attrs.setFormat("image2");//转图片编码
			attrs.setOffset((float)i);//设置偏移位置，即开始转码位置（秒）
			attrs.setDuration(0.01f);//设置转码持续时间（1秒）
			attrs.setVideoAttributes(video);
			try {
				long beginTime = System.currentTimeMillis();
				 String targetPath=targetOriginPath+i+"."+targetStyle;//循环生成的图片地址
				 File target = new File(targetPath);//转图片地址  4.png
				encoder.encode(source, target, attrs);
				System.out.println("视频转码花费时间是：" + (System.currentTimeMillis() - beginTime));
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InputFormatException e) {
				e.printStackTrace();
			} catch (EncoderException e) {
				e.printStackTrace();
			}
		}
		
	}
}
