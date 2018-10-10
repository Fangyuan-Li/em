package com.em.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.em.bean.Application;
import com.em.bean.Equipment;
import com.em.service.ApplicationService;
import com.huawei.iotplatform.client.NorthApiException;

@Controller
public class ApplicationController {
	
	public static Logger log = Logger.getLogger(ApplicationController.class);
	
	@Resource
	private ApplicationService appService;
	
	/*
	 * 查询所有应用
	 */
	@RequestMapping("index")
	public ModelAndView findApps() {
		ModelAndView mv = new ModelAndView();
		List<Application> applist = appService.findAppList();
		mv.addObject("appList",applist);
		mv.setViewName("/app/appList.jsp");
		return mv;
	}
	/*
	 * 跳转到添加应用
	 */
	@RequestMapping("appCreatePre")
	public ModelAndView appCreatePre() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/app/appCreate.jsp");
		return mv;
	}
	/*
	 * 添加应用
	 */
	@RequestMapping("appCreate")
	public ModelAndView appCreate(Application app) {
		ModelAndView mv = new ModelAndView("redirect:index");
		log.debug("app:"+app.toString());
		appService.appCreate(app);
		return mv;
	}
	
	/*
	 * 进入修改应用密钥页面
	 */
	@RequestMapping("updateAppPre")
	public ModelAndView updateAppPre(@RequestParam String appId) throws NorthApiException{
		ModelAndView mv = new ModelAndView();
		mv.addObject("appId", appId);
		mv.setViewName("/app/appUpdate.jsp");
		return mv;
	}
	/*
	 * 修改应用密钥
	 */
	@RequestMapping("updateApp")
	public ModelAndView updateApp(@RequestParam String appId,String secret) throws NorthApiException{
		ModelAndView mv = new ModelAndView("redirect:index");
		appService.updateApp(appId,secret);
		mv.addObject("appId", appId);
		//mv.setViewName("/app/appUpdate.jsp");
		return mv;
	}
	/*
	 * 查看指定应用的设备
	 */
	@RequestMapping("findEquipments")
	public ModelAndView findEquipments(@RequestParam String appId) throws NorthApiException{
		ModelAndView mv = new ModelAndView();
		List<Equipment> equipList = appService.findEquipList(appId);
		mv.addObject("equipList",equipList);
		mv.addObject("appId", appId);
		mv.setViewName("/app/equipList.jsp");
		return mv;
	}
	/*
	 * 启动应用，让平台可以推送信息到该应用
	 */
	@RequestMapping("start")
	public ModelAndView start(@RequestParam String appId,String secret) throws NorthApiException{
		ModelAndView mv = new ModelAndView("redirect:index");
		//appService.start(appId,secret);
		return mv;
	}
	/*
	 * 删除应用
	 */
	@RequestMapping("deleteApp")
	public ModelAndView deleteApp(@RequestParam String appId) throws NorthApiException{
		ModelAndView mv = new ModelAndView("redirect:index");
		appService.deleteApp(appId);
		return mv;
	}
}
