package com.demo.video2pic.bean;

import java.io.Serializable;


/**
 *
 */
public class Result implements Serializable{
	private boolean success = true;
	private int retCode = 0;
	private String msg;
	private Object retObj;

	public Result() {}

	public Result(boolean success, int retCode, String msg, Object retObj) {
		this.success = success;
		this.retCode = retCode;
		this.msg = msg;
		this.retObj = retObj;
	}

	public Result(Object object) {
		this.retObj = object;
	}

	public Result(int code, Object object) {
		this.retCode = code;
		this.retObj = object;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getRetObj() {
		return retObj;
	}

	public void setRetObj(Object retObj) {
		this.retObj = retObj;
	}

}
