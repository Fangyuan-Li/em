package com.em.service;

import com.em.bean.CommandHis;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdOutDTO;

public interface EquipService {
	/**
	 * 创建命令
	 * @param appId
	 * @param secret
	 * @param profile
	 * @throws NorthApiException
	 */
	public PostDeviceCommandOutDTO postDeviceCommand(String appId,String secret,CommandHis profile) throws NorthApiException;
	/**
	 * 厂商应用服务器查询设备命令
	 * @param appId
	 * @param secret
	 * @param profile
	 * @return
	 * @throws NorthApiException
	 */
	public QueryDeviceCommandOutDTO queryDeviceCommand(String appId,String secret,CommandHis profile) throws NorthApiException;
	/**
	 * 修改命令信息，当前仅支持修改设备命令状态为撤销，即为将设备命令撤销
	 * @param appId
	 * @param secret
	 * @param deviceCommandId
	 * @return
	 * @throws NorthApiException
	 */
	public UpdateDeviceCmdOutDTO updateDeviceCommand(String appId, String secret,String deviceCommandId)throws NorthApiException;
	/**
	 * 创建设备命令撤销任务，该任务用于撤销指定设备ID下的所有设备命令
	 * @param appId
	 * @param secret
	 * @param deviceId
	 * @return
	 * @throws NorthApiException
	 */
	public DeviceCmdCancelTaskOutDTO createDeviceCmdCancelTask(String appId, String secret, String deviceId)throws NorthApiException;
	/**
	 * 查询设备命令撤销任务
	 * @param appId
	 * @param secret
	 * @param deviceId
	 * @return
	 * @throws NorthApiException
	 */
	public QueryDeviceCmdCancelTaskOutDTO queryDeviceCmdCancelTask(String appId, String secret,String deviceId)throws NorthApiException;
	/**
	 * 添加设备
	 * @param name
	 * @param id
	 */
	public void addEquip(String appId,String deviceName, String deviceId);
	public void deleteEquip(String deviceId);
	public String findAppId(String deviceId);
}
