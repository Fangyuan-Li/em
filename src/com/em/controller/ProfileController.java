package com.em.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.em.bean.Command;
import com.em.bean.Profile;
import com.em.bean.Property;
import com.em.service.ProfileService;



@Controller
public class ProfileController {
	
	public static Logger log = Logger.getLogger(ProfileController.class);
	
	@Resource ProfileService profileService;
	/*
	 * 
	 */
	@RequestMapping("profileCreatePre")
	public ModelAndView profileCreatePre(@RequestParam String appName){
		ModelAndView mv = new ModelAndView();
		mv.addObject("appName", appName);
		mv.setViewName("/app/profileCreate.jsp");
		return mv;
	}
	@RequestMapping("profileCreate")
	public ModelAndView profileCreate(Profile profile){
		ModelAndView mv = new ModelAndView();
		/*SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
		String tradecode = sdf1.format(new Date());*/
		profileService.createProfile(profile);
		mv.setViewName("/app/profileList.jsp");
		return mv;
	}
	@RequestMapping("findProperties")
	public ModelAndView findProperties(@RequestParam String id){
		ModelAndView mv = new ModelAndView();
		List<Property> propertyList = profileService.findProperties(id);
		mv.addObject("propertyList", propertyList);
		mv.setViewName("/app/profilePropertyList.jsp");
		return mv;
	}
	@RequestMapping("findMethods")
	public ModelAndView findMethods(@RequestParam String id){
		ModelAndView mv = new ModelAndView();
		List<Command> commandList = profileService.findMethods(id);
		mv.addObject("commandList", commandList);
		mv.setViewName("/app/profileCommandList.jsp");
		return mv;
	}
}
