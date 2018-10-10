package com.em.bean;

import java.util.List;

public class Application {
	private String appName;// 应用名称
	private String appId;// 应用ID
	private String secret;// 应用密钥

	private List<Equipment> equipList;// 该应用所有的设备

	public Application(String appName, String appId, String secret, List<Equipment> equipList) {
		super();
		this.appName = appName;
		this.appId = appId;
		this.secret = secret;
		this.equipList = equipList;
	}

	public Application() {
		super();
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public List<Equipment> getEquipList() {
		return equipList;
	}

	public void setEquipList(List<Equipment> equipList) {
		this.equipList = equipList;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "Application [appId=" + appId + ", secret=" + secret + "]";
	}

}
