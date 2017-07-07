package com.demo.video2pic.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

/**
 * 用户
 */
@Alias("User")
public class User implements Serializable{
	
	private Long id;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}