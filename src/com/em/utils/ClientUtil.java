package com.em.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.em.controller.ApplicationController;
import com.huawei.iotplatform.client.NorthApiClient;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.AuthOutDTO;
import com.huawei.iotplatform.client.dto.ClientInfo;
import com.huawei.iotplatform.client.invokeapi.Authentication;
import com.huawei.iotplatform.client.invokeapi.SignalDelivery;

public class ClientUtil {
	
	public static Logger log = Logger.getLogger(ClientUtil.class);
	
	public static Map<String, Object> getClient(String appId,String secret) throws NorthApiException{
		NorthApiClient nac = new NorthApiClient();

		ClientInfo ci = new ClientInfo();

		ci.setAppId(appId);
		ci.setPlatformIp("180.101.147.89");
		ci.setPlatformPort("8743");

		ci.setSecret(secret);

		nac.setClientInfo(ci);
		nac.initSSLConfig();

		Authentication aaa = new Authentication(nac);

		AuthOutDTO aod = null;
		aod = aaa.getAuthToken();
		String accessToken = aod.getAccessToken();
		
		SignalDelivery sd = new SignalDelivery();
		sd.setNorthApiClient(nac);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaa", aaa);
		map.put("accessToken", accessToken);
		map.put("sd", sd);
		return map;
	}
}
