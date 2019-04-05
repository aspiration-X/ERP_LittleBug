package com.littlebug.dao;

import com.littlebug.bean.DeviceCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceCheckMapper {
    List<DeviceCheck> selectDeviceCheckList();

    List<DeviceCheck> selectDeviceCheckListById(@Param("id") String id);

    List<DeviceCheck> selectDeviceCheckListByDeviceName(@Param("deviceName") String deviceName);

    int deleteByPrimaryKey(String deviceCheckId);

    int deleteDeviceCheckList(@Param("ids") String[] ids);

    int insert(DeviceCheck record);

    int insertSelective(DeviceCheck record);

    DeviceCheck selectByPrimaryKey(String deviceCheckId);

    int updateByPrimaryKeySelective(DeviceCheck record);

    int updateByPrimaryKey(DeviceCheck record);
}