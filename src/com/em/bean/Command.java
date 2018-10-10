package com.em.bean;

public class Command {
	private String appId;
	private String method;
	private String field;
	private String description;

	public Command() {
		super();
	}

	public Command(String appId, String method, String field, String description) {
		super();
		this.appId = appId;
		this.method = method;
		this.field = field;
		this.description = description;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Command [appId=" + appId + ", method=" + method + ", field=" + field + ", description=" + description
				+ "]";
	}

}
