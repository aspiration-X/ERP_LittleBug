package com.littlebug.dao;

import com.littlebug.bean.Device;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMapper {
    List<Device> selectAllDevices();

    List<Device> selectDeviceListByDeviceId(@Param("deviceId") String deviceId);

    List<Device> selectDeviceListByDeviceName(@Param("deviceName") String deviceName);

    List<Device> selectDeviceListByDeviceTypeName(@Param("deviceTypeName") String deviceTypeName);

    int updateNoteByDeviceId(@Param("deviceId") String deviceId, @Param("note") String note);

    int deleteByPrimaryKey(String deviceId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String deviceId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);

    int deleteDeviceByIds(@Param("ids") String[] ids);
}