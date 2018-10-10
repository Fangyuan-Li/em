package com.em.bean;

public class Property {
	private String appId;
	private String serviceId;
	private String field;

	public Property() {
		super();
	}

	public Property(String appId, String serviceId, String field) {
		super();
		this.appId = appId;
		this.serviceId = serviceId;
		this.field = field;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "Property [appId=" + appId + ", serviceId=" + serviceId + ", field=" + field + "]";
	}

}
