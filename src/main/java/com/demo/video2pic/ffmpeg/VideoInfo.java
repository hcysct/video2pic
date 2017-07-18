package com.demo.video2pic.ffmpeg;

/**
 * 视频信息
 * @author zyh
 *
 */
public class VideoInfo {

	private int seconds;//秒数
	private int width;//分辨率的宽 比如 1920
	private int height;//分辨率的高 比如 1080
	private String title;
	public int getSeconds() {
		return seconds;
	}
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public VideoInfo() {
		super();
	}
	public VideoInfo(int seconds, int width, int height, String title) {
		super();
		this.seconds = seconds;
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	
}
