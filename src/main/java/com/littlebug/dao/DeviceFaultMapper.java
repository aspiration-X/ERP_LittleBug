package com.littlebug.dao;

import com.littlebug.bean.DeviceFault;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeviceFaultMapper {
    int deleteByPrimaryKey(String deviceFaultId);

    int deleteBatchByPrimaryKey(@Param("ids") String[] ids);

    int insert(DeviceFault record);

    int insertSelective(DeviceFault record);

    DeviceFault selectByPrimaryKey(String deviceFaultId);

    int updateByPrimaryKeySelective(DeviceFault record);

    int updateByPrimaryKey(DeviceFault record);

    List<DeviceFault> selectDeviceFaultList();

    List<DeviceFault> selectDeviceFaultListById(@Param("id") String id);

    List<DeviceFault> selectDeviceFaultListByDeviceName(@Param("deviceName") String deviceName);

    int updateDeviceFaultNote(@Param("deviceFaultId") String deviceFaultId,@Param("deviceFaultDetail") String deviceFaultDetail);
}