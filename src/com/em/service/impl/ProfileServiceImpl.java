package com.em.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.em.bean.Command;
import com.em.bean.Profile;
import com.em.bean.Property;
import com.em.mapper.ProfileMapper;
import com.em.service.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Resource ProfileMapper profileMapper;
	@Override
	public void createProfile(Profile profile) {
		profileMapper.createProfile(profile);
	}
	@Override
	public List<Property> findProperties(String id) {
		return profileMapper.findProperties(id);
	}
	@Override
	public List<Command> findMethods(String id) {
		return profileMapper.findMethods(id);
	}
	
}
