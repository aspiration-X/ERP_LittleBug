package com.littlebug.dao;

import com.littlebug.bean.DeviceType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceTypeMapper {
    List<DeviceType> selectAllDeviceTypes();

    int deleteByIds(@Param("ids") String[] ids);

    int deleteByPrimaryKey(String deviceTypeId);

    int insert(DeviceType record);

    List<DeviceType> selectById(@Param("deviceTypeId") String deviceTypeId);

    List<DeviceType> selectByName(@Param("deviceTypeName") String deviceTypeName);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(String deviceTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);
}