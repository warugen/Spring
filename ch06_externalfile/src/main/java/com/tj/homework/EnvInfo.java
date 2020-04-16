package com.tj.homework;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnvInfo {
	@Value("${ipNum}")
	private String ipNum;
	@Value("${portNum}")
	private String portNum;
	@Value("${userId}")
	private String userId;
	@Value("${userPw}")
	private String userPw;
	public String getIpNum() {
		return ipNum;
	}
	public void setIpNum(String ipNum) {
		this.ipNum = ipNum;
	}
	public String getPortNum() {
		return portNum;
	}
	public void setPortNum(String portNum) {
		this.portNum = portNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	@Bean
	public EnvInfo envInfo() {
		EnvInfo info = new EnvInfo();
		info.setIpNum(ipNum);
		info.setPortNum(portNum);
		info.setUserId(userId);
		info.setUserPw(userPw);
		
		return info;
	}
	
}
