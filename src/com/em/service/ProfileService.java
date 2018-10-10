package com.em.service;

import java.util.List;

import com.em.bean.Command;
import com.em.bean.Profile;
import com.em.bean.Property;

public interface ProfileService {

	public void createProfile(Profile profile);

	public List<Property> findProperties(String id);

	public List<Command> findMethods(String id);
	
}
