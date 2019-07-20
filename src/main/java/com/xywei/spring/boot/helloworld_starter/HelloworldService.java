package com.xywei.spring.boot.helloworld_starter;

public class HelloworldService {

	private String username;

	public String sayHello() {
		return "hello," + ((username == null || "".equals(username)) ? "" : username);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
