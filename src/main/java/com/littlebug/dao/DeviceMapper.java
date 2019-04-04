package com.littlebug.dao;

import com.littlebug.bean.Device;

import java.util.List;

public interface DeviceMapper {
    List<Device> selectAllDevices();

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}