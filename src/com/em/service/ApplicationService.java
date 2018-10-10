package com.em.service;

import java.util.List;

import com.em.bean.Application;
import com.em.bean.Equipment;
import com.huawei.iotplatform.client.NorthApiException;

public interface ApplicationService {
	/**
	 * 添加应用
	 * @param application
	 */
	public void appCreate(Application application);

	public List<Application> findAppList();

	public List<Equipment> findEquipList(String appId);

	public void start(String appId, String secret) throws NorthApiException;

	public void updateApp(String appId,String secret);

	public String findSecret(String appId);

	public void deleteApp(String appId);
}
