package com.demo.video2pic.test;

import java.io.File;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.EncodingAttributes;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;
import it.sauronsoftware.jave.VideoAttributes;
import it.sauronsoftware.jave.VideoSize;

/**]
 * JAVE是ffmpeg对java的封装
 * 支持windows和linux
 * 在windows平台 jave已经包含了ffmpeg.exe可执行程序，但在linux需要额外配置环境
 * @author zyh
 *
 */
public class JaveTest {

	public static void main(String[] args) {
		
		toPng();
		
		System.out.println("结束");
		
	}
	/**
	 * 将视频转为图片
	 */
	public static void toPng() {
		String sourcePath="D:\\test\\gee.mp4";
		String targetOriginPath="D:\\test\\gee_";//默认图片名称
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
	
	
	public static void toflv(){
		File source = new File("E:\\test\\source.mp4");
		File target = new File("E:\\test\\target.flv");// 转flv

		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(64000));
		audio.setChannels(new Integer(1));
		audio.setSamplingRate(new Integer(22050));
		VideoAttributes video = new VideoAttributes();
		video.setCodec("flv");// 转flv
		video.setBitRate(new Integer(180000));// 180kb/s比特率
		video.setFrameRate(new Integer(1));// 1f/s帧频，1是目前测试比较清楚的，越大越模糊
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("flv");// 转flv
		attrs.setAudioAttributes(audio);
		attrs.setVideoAttributes(video);
		Encoder encoder = new Encoder();
		long beginTime = System.currentTimeMillis();
		try {
			// 获取时长
			MultimediaInfo m = encoder.getInfo(source);
			long sTime = m.getDuration();
			long minute = sTime / 60000;
			long second = (sTime % 60000) / 1000;
			System.out.println("视频时长：" + minute + ":" + (second < 10 ? "0" + second : second));
			System.out.println("获取时长花费时间是：" + (System.currentTimeMillis() - beginTime));
			beginTime = System.currentTimeMillis();
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
	
	public static void toMp4() {
		File source = new File("E:\\test\\source.avi");
		File target = new File("E:\\test\\target.mp4");// 转MP4

		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("libmp3lame");
		audio.setBitRate(new Integer(64000));
		audio.setChannels(new Integer(1));
		audio.setSamplingRate(new Integer(22050));
		VideoAttributes video = new VideoAttributes();
		video.setCodec("libxvid");// 转MP4
		video.setBitRate(new Integer(180000));// 180kb/s比特率
		video.setFrameRate(new Integer(1));// 1f/s帧频，1是目前测试比较清楚的，越大越模糊
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("mp4");// 转MP4
		attrs.setAudioAttributes(audio);
		attrs.setVideoAttributes(video);
		Encoder encoder = new Encoder();
		long beginTime = System.currentTimeMillis();
		try {
			// 获取时长
			MultimediaInfo m = encoder.getInfo(source);
			System.out.println(m.getDuration());
			System.out.println("获取时长花费时间是：" + (System.currentTimeMillis() - beginTime));
			beginTime = System.currentTimeMillis();
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
