package com.em.bean;

/**
 * 设备类型实体类
 *
 */
public class Profile {
	private String id;
	private String appName;
	private String type;
	private String producer;
	private String serviceId;
	private String method;

	// private String property;
	// private String command;
	public Profile() {
		super();
	}

	public Profile(String id, String appName, String type, String producer, String serviceId, String method) {
		super();
		this.id = id;
		this.appName = appName;
		this.type = type;
		this.producer = producer;
		this.serviceId = serviceId;
		this.method = method;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", appName=" + appName + ", type=" + type + ", producer=" + producer
				+ ", serviceId=" + serviceId + ", method=" + method + "]";
	}

}
