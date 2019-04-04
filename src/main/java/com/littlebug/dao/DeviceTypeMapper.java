package com.littlebug.dao;

import com.littlebug.bean.DeviceType;

import java.util.List;

public interface DeviceTypeMapper {
    List<DeviceType> selectAllDeviceTypes();

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);
}