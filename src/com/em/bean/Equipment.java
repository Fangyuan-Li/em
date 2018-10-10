package com.em.bean;

/**
 * 设备实体类
 * 
 * @author Administrator
 *
 */
public class Equipment {
	private String deviceId;// 设备ID
	private String deviceName;// 设备名称
	private String appId;// 设备所属应用

	public Equipment() {
		super();
	}

	public Equipment(String deviceId, String deviceName, String appId) {
		super();
		this.deviceId = deviceId;
		this.deviceName = deviceName;
		this.appId = appId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "Equipment [deviceId=" + deviceId + ", deviceName=" + deviceName + ", appId=" + appId + "]";
	}

}
