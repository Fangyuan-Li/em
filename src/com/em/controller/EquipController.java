package com.em.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.em.bean.CommandHis;
import com.em.service.ApplicationService;
import com.em.service.EquipService;
import com.huawei.iotplatform.client.NorthApiException;
import com.huawei.iotplatform.client.dto.DeviceCmdCancelTaskOutDTO;
import com.huawei.iotplatform.client.dto.PostDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.QueryDeviceCommandOutDTO;
import com.huawei.iotplatform.client.dto.UpdateDeviceCmdOutDTO;

@Controller
public class EquipController {
	
	public static Logger log = Logger.getLogger(ApplicationController.class);
	
	@Resource
	private EquipService equipService;
	@Resource
	private ApplicationService appService;
	/*
	 * 进入添加设备页面
	 */
	@RequestMapping("addEquipPre")
	public ModelAndView addEquipPre(@RequestParam String appId) throws NorthApiException{
		ModelAndView mv = new ModelAndView();
		mv.addObject("appId", appId);
		mv.setViewName("/app/equipAdd.jsp");
		return mv;
	}
	/*
	 * 添加设备
	 */
	@RequestMapping("addEquip")
	public ModelAndView addEquip(@RequestParam String appId,String deviceName,String deviceId) throws NorthApiException{
		ModelAndView mv = new ModelAndView("redirect:findEquipments");
		/*Equipment equip = new Equipment();
		equip.setName(name);
		equip.setId(id);*/
		equipService.addEquip(appId,deviceName,deviceId);
		mv.addObject("appId", appId);
		return mv;
	}
	/*
	 * 删除设备
	 */
	@RequestMapping("deleteEquip")
	public ModelAndView deleteEquip(@RequestParam String deviceId,String appId) throws NorthApiException{
		ModelAndView mv = new ModelAndView("redirect:findEquipments");
		equipService.deleteEquip(deviceId);
		mv.addObject("appId",appId);
		return mv;
	}
	/*
	 * 进入发送指令页面
	 */
	@RequestMapping("postDeviceCommandPre")
	public ModelAndView postDeviceCommandPre(@RequestParam String deviceId) throws NorthApiException{
		log.info("进入发送命令页面…………………………………………");
		ModelAndView mv = new ModelAndView();
		mv.addObject("deviceId", deviceId);
		mv.setViewName("/app/equipPostCommand.jsp");
		return mv;
	}
	/*
	 * 4.4.1 发送指令
	 */
	@RequestMapping("postDeviceCommand")
	public ModelAndView postDeviceCommand(CommandHis profile) throws NorthApiException{
		log.info("发送命令…………………………………………");
		ModelAndView mv = new ModelAndView("redirect:findEquipments");
		String deviceId = profile.getDeviceId();
		String appId = equipService.findAppId(deviceId);
		String secret = appService.findSecret(appId);
		PostDeviceCommandOutDTO pdcod = equipService.postDeviceCommand(appId, secret, profile);
		//保存发送的命令到数据库
		String commandId = pdcod.getCommandId();
		log.info("commandId："+commandId);
		log.info("发送命令反馈："+pdcod);
		mv.addObject("appId", appId);
		return mv;
	}
	/*
	 * 4.4.2 查询发送的命令
	 */
	@RequestMapping("queryCommand")
	public ModelAndView queryCommand(CommandHis profile) throws NorthApiException{
		log.info("查询发送的命令…………………………………………");
		ModelAndView mv = new ModelAndView();
		String deviceId = profile.getDeviceId();
		String appId = equipService.findAppId(deviceId);
		String secret = appService.findSecret(appId);
		QueryDeviceCommandOutDTO qdcod = equipService.queryDeviceCommand(appId, secret, profile);
		log.info("查询发送的命令反馈："+qdcod);
		mv.addObject("qdcod", qdcod);
		mv.setViewName("/app/equipQueryCommand.jsp");
		return mv;
	}
	/*
	 * 进入撤销命令页面
	 */
	@RequestMapping("updateCommandPre")
	public ModelAndView updateCommandPre(@RequestParam String deviceId) throws NorthApiException{
		log.info("进入撤销命令页面…………………………………………");
		ModelAndView mv = new ModelAndView();
		mv.addObject("deviceId", deviceId);
		mv.setViewName("/app/equipCancelCommand.jsp");
		return mv;
	}
	/*
	 * 4.4.3 撤销命令
	 */
	@RequestMapping("updateCommand")
	public ModelAndView updateCommand(@RequestParam String deviceId,String deviceCommandId) throws NorthApiException{
		log.info("撤销命令…………………………………………");
		ModelAndView mv = new ModelAndView("redirect:findEquipments");
		String appId = equipService.findAppId(deviceId);
		String secret = appService.findSecret(appId);
		UpdateDeviceCmdOutDTO udcod = equipService.updateDeviceCommand(appId, secret, deviceCommandId);
		log.info("撤销命令反馈:"+udcod);
		//mv.addObject("udcod", udcod);
		return mv;
	}
	/*
	 * 4.4.4 创建设备命令撤销任务
	 */
	@RequestMapping("createCmdCancelTask")
	public ModelAndView createCmdCancelTask(@RequestParam String deviceId) throws NorthApiException{
		log.info("撤销所有命令…………………………………………");
		ModelAndView mv = new ModelAndView();
		String appId = equipService.findAppId(deviceId);
		String secret = appService.findSecret(appId);
		DeviceCmdCancelTaskOutDTO dcctod = equipService.createDeviceCmdCancelTask(appId, secret, deviceId);
		log.info("撤销所有命令反馈:"+dcctod);
		mv.addObject("dcctod", dcctod);
		mv.setViewName("/app/equipQueryCommand.jsp");
		return mv;
	}
	/*
	 * 4.4.5 查询设备命令取消任务
	 */
	@RequestMapping("queryCmdCancelTask")
	public ModelAndView queryCmdCancelTask(@RequestParam String deviceId) throws NorthApiException{
		log.info("查询设备命令取消任务…………………………………………");
		ModelAndView mv = new ModelAndView();
		String appId = equipService.findAppId(deviceId);
		String secret = appService.findSecret(appId);
		DeviceCmdCancelTaskOutDTO dcctod = equipService.createDeviceCmdCancelTask(appId, secret, deviceId);
		log.info("查询设备命令取消任务反馈:"+dcctod);
		mv.addObject("dcctod", dcctod);
		mv.setViewName("/app/equipQueryCommand.jsp");
		return mv;
	}
}
