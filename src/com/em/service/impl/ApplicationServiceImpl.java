package com.em.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.em.bean.Application;
import com.em.bean.Equipment;
import com.em.mapper.ApplicationMapper;
import com.em.mapper.EquipMapper;
import com.em.service.ApplicationService;
import com.huawei.iotplatform.client.NorthApiClient;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.AuthOutDTO;
import com.huawei.iotplatform.client.dto.ClientInfo;
import com.huawei.iotplatform.client.dto.SubscribeInDTO;
import com.huawei.iotplatform.client.invokeapi.Authentication;
import com.huawei.iotplatform.client.invokeapi.DataCollection;

@Service
public class ApplicationServiceImpl implements ApplicationService{
	@Resource
	private ApplicationMapper appMapper;
	@Resource
	private EquipMapper equipMapper;
	
	@Override
	public List<Application> findAppList() {
		return appMapper.findAppList();
	}
	
	public void appCreate(Application application) {
		appMapper.appCreate(application);
	}

	@Override
	public void updateApp(String appId,String secret) {
		appMapper.updateApp(appId,secret);
	}
	
	@Override
	public List<Equipment> findEquipList(String appId) {
		return equipMapper.findEquipList(appId);
	}
	
	@Override
	public void start(String appId, String secret) throws NorthApiException {
		NorthApiClient nac = new NorthApiClient();
		ClientInfo ci = new ClientInfo();
		
//		String appId = "g8PzhYyfLMZfVuOUpWVaJqM70Hca";
//		String secret = "feAxDQJDSqJnnZr0ue3LoHR5CbMa";
		
		ci.setAppId(appId);
		ci.setPlatformIp("180.101.147.89");
		ci.setPlatformPort("8743");
		ci.setSecret(secret);
		try {
			nac.setClientInfo(ci);
			nac.initSSLConfig();
		} catch (NorthApiException e) {
			throw new RuntimeException(e);
		}

		DataCollection dc = new DataCollection(nac);
		System.out.println(ci.toString());
		Authentication aaa = new Authentication(nac);

		// 4.1.1 
		AuthOutDTO aod = null;
		aod = aaa.getAuthToken();

		String accessToken = aod.getAccessToken();
		System.out.println("accessToken:"+accessToken);
		// 4.3.5 
		SubscribeInDTO sid = new SubscribeInDTO();

		String notifyType = "deviceDataChanged";
		String callbackurl = "https://211.81.248.107:8443/data/DataCollectServlet";
		
		sid.setNotifyType(notifyType);
		sid.setCallbackurl(callbackurl);

		dc.subscribeNotify(sid, accessToken);
		System.out.println(sid);
		// 4.1.3 
		aaa.logoutAuthToken(accessToken);
	}

	@Override
	public String findSecret(String appId) {
		return appMapper.finSecret(appId);
	}

	@Override
	public void deleteApp(String appId) {
		appMapper.deleteApp(appId);
	}
	
}
