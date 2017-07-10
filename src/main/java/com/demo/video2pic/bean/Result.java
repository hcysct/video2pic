package com.demo.video2pic.bean;

import java.io.Serializable;


/**
 * 结果集
 */
public class Result implements Serializable{
	//true false
	private boolean success = true;
	//0 -1
	private int resultCode = 0;
	//消息
	private String msg;
	private Object resultObj;

	public Result() {}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResultObj() {
		return resultObj;
	}

	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}

	public Result(boolean success, int resultCode, String msg, Object resultObj) {
		super();
		this.success = success;
		this.resultCode = resultCode;
		this.msg = msg;
		this.resultObj = resultObj;
	}



}
