package com.littlebug.dao;

import com.littlebug.bean.DeviceMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceMaintainMapper {
    List<DeviceMaintain> selectDeviceMaintainList();

    List<DeviceMaintain> selectDeviceMaintainListById(@Param("id") String id);

    List<DeviceMaintain> selectDeviceMaintainListByDeviceFaultId(@Param("deviceFaultId") String deviceFaultId);

    int deleteByPrimaryKey(String deviceMaintainId);

    int insert(DeviceMaintain record);

    int insertSelective(DeviceMaintain record);

    DeviceMaintain selectByPrimaryKey(String deviceMaintainId);

    int updateByPrimaryKeySelective(DeviceMaintain record);

    int updateByPrimaryKey(DeviceMaintain record);

    int deleteDeviceMaintainByIds(@Param("ids") String[] ids);
}