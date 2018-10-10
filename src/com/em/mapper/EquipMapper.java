package com.em.mapper;

import java.util.List;

import com.em.bean.Equipment;

public interface EquipMapper {

	public List<Equipment> findEquipList(String appId);

	public void addEquip(String appId,String deviceName, String deviceId);

	public void deleteEquip(String deviceId);

	public String findAppId(String deviceId);

}
