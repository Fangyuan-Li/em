package com.em.mapper;

import java.util.List;

import com.em.bean.Application;

public interface ApplicationMapper {
	/**
	 * 添加应用
	 * @param application
	 */
	public void appCreate(Application application);
	/**
	 * 查询所有应用
	 * @return
	 */
	public List<Application> findAppList();
	/**
	 * 修改应用密钥
	 * @param application
	 */
	public void updateApp(String appId,String secret);
	/**
	 * 根据应用ID查询密钥
	 * @param appId
	 * @return
	 */
	public String finSecret(String appId);
	/**
	 * 删除应用
	 * @param appId
	 */
	public void deleteApp(String appId);
}
