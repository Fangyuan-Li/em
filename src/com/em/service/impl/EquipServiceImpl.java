package com.em.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.em.bean.CommandHis;
import com.em.mapper.ApplicationMapper;
import com.em.mapper.EquipMapper;
import com.em.service.EquipService;
import com.em.utils.ClientUtil;
import com.em.utils.Constant;
import com.em.utils.JsonUtil;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.AsynCommandDTO;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskInDTO;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCmdCancelTaskInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandInDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdInDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdOutDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdReq;
import com.huawei.iotplatform.client.invokeapi.Authentication;
import com.huawei.iotplatform.client.invokeapi.SignalDelivery;

@Service
public class EquipServiceImpl implements EquipService {
	
	public static Logger log = Logger.getLogger(EquipServiceImpl.class);
	
	@Resource
	private EquipMapper equipMapper;
	@Resource
	private ApplicationMapper appMapper;
	/*
	 * 给设备发送命令
	 */
	@Override
	public PostDeviceCommandOutDTO postDeviceCommand(String appId,String secret,CommandHis profile) throws NorthApiException {
		Map<String, Object> client = ClientUtil.getClient(appId, secret);//map包含SignalDelivery对象和accessToken
		String accessToken = (String) client.get("accessToken");
		SignalDelivery sd = (SignalDelivery)client.get("sd");
		
		PostDeviceCommandInDTO pdcid = new PostDeviceCommandInDTO();
		pdcid.setDeviceId(profile.getDeviceId());
		AsynCommandDTO acdo = new AsynCommandDTO();
		String serviceId = Constant.SERVICEID;
		String method = Constant.METHOD;
		//设置命令
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("SleepTimeSendS", profile.getSleepsend());
		map.put("Senticity", profile.getSenticity());
		map.put("MoveSendTimeS", profile.getMovesend());
		map.put("SleepTime", profile.getSleeptime());
		map.put("VoltThreshod", profile.getVolt());
		map.put("WakeTime", profile.getWaketime());

		ObjectNode paras = null;
		try {
			paras = JsonUtil.convertObject2ObjectNode(map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		acdo.setServiceId(serviceId);
		acdo.setMethod(method);
		acdo.setParas(paras);

		pdcid.setCommand(acdo);
		
		PostDeviceCommandOutDTO pdcod = sd.postDeviceCommand(pdcid, appId, accessToken);
		//注销鉴权信息
		Authentication aaa = (Authentication) client.get("aaa");
		aaa.logoutAuthToken(accessToken);
		return pdcod;
	}
	
	/*
	 * 查询设备的命令
	 */
	@Override
	public QueryDeviceCommandOutDTO queryDeviceCommand(String appId, String secret, CommandHis profile)
			throws NorthApiException {
		Map<String, Object> client = ClientUtil.getClient(appId, secret);//map包含SignalDelivery对象和accessToken
		String accessToken = (String) client.get("accessToken");
		SignalDelivery sd = (SignalDelivery)client.get("sd");
		
		QueryDeviceCommandInDTO qdcid = new QueryDeviceCommandInDTO();
		qdcid.setDeviceId(profile.getDeviceId());
		QueryDeviceCommandOutDTO qdcod = sd.queryDeviceCommand(qdcid, appId,
				accessToken);
		//注销鉴权信息
		Authentication aaa = (Authentication) client.get("aaa");
		aaa.logoutAuthToken(accessToken);
		return qdcod;
	}

	/*
	 * 4.4.3 修改设备命令
	 */
	@Override
	public UpdateDeviceCmdOutDTO updateDeviceCommand(String appId, String secret, String deviceCommandId)
			throws NorthApiException {
		Map<String, Object> client = ClientUtil.getClient(appId, secret);//map包含SignalDelivery对象和accessToken
		String accessToken = (String) client.get("accessToken");
		SignalDelivery sd = (SignalDelivery)client.get("sd");
		
		UpdateDeviceCmdInDTO udcid = new UpdateDeviceCmdInDTO();
		udcid.setDeviceCommandId(deviceCommandId);
		UpdateDeviceCmdReq udcr = new UpdateDeviceCmdReq();
		udcr.setStatus("CANCELED");
		udcid.setUpdateDeviceCommandReq(udcr);
		UpdateDeviceCmdOutDTO udcod = sd.updateDeviceCommand(udcid, appId,
				accessToken);
		//注销鉴权信息
		Authentication aaa = (Authentication) client.get("aaa");
		aaa.logoutAuthToken(accessToken);
		return udcod;
	}

	/*
	 * 4.4.4 创建设备命令撤销任务
	 */
	@Override
	public DeviceCmdCancelTaskOutDTO createDeviceCmdCancelTask(String appId, String secret, String deviceId)
			throws NorthApiException {
		Map<String, Object> client = ClientUtil.getClient(appId, secret);//map包含SignalDelivery对象和accessToken
		String accessToken = (String) client.get("accessToken");
		SignalDelivery sd = (SignalDelivery)client.get("sd");
		
		DeviceCmdCancelTaskInDTO dcctod = new DeviceCmdCancelTaskInDTO();
		dcctod.setDeviceId(deviceId);
		DeviceCmdCancelTaskOutDTO dcctoud = sd.createDeviceCmdCancelTaskV4(
				dcctod, appId, accessToken);
		
		//注销鉴权信息
		Authentication aaa = (Authentication) client.get("aaa");
		aaa.logoutAuthToken(accessToken);
		return dcctoud;
	}
	/*
	 * 查询设备设备命令取消任务
	 */
	@Override
	public QueryDeviceCmdCancelTaskOutDTO queryDeviceCmdCancelTask(String appId, String secret,String deviceId) throws NorthApiException {
		Map<String, Object> client = ClientUtil.getClient(appId, secret);//map包含SignalDelivery对象和accessToken
		String accessToken = (String) client.get("accessToken");
		SignalDelivery sd = (SignalDelivery)client.get("sd");
		
		QueryDeviceCmdCancelTaskInDTO qdcctid = new QueryDeviceCmdCancelTaskInDTO();
		qdcctid.setDeviceId(deviceId);
		QueryDeviceCmdCancelTaskOutDTO qdcctod = sd.queryDeviceCmdCancelTask(
				qdcctid, appId, accessToken);
		
		//注销鉴权信息
		Authentication aaa = (Authentication) client.get("aaa");
		aaa.logoutAuthToken(accessToken);
		return qdcctod;
	}

	@Override
	public void addEquip(String appId,String deviceName, String deviceId) {
		equipMapper.addEquip(appId,deviceName, deviceId);
	}

	@Override
	public void deleteEquip(String deviceId) {
		equipMapper.deleteEquip(deviceId);
		
	}

	@Override
	public String findAppId(String deviceId) {
		return equipMapper.findAppId(deviceId);
	}

}
