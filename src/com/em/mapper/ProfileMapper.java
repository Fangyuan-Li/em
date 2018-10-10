package com.em.mapper;

import java.util.List;

import com.em.bean.Command;
import com.em.bean.Profile;
import com.em.bean.Property;

public interface ProfileMapper {
	/**
	 * 创建自定义设备类型
	 * @param profile
	 */
	public void createProfile(Profile profile);
	/**
	 * 查询指定设备类型的属性
	 * @param id
	 * @return
	 */
	public List<Property> findProperties(String id);
	/**
	 * 查询指定设备的命令
	 * @param id
	 * @return
	 */
	public List<Command> findMethods(String id);

}
