package com.littlebug.service;

import com.littlebug.bean.Device;
import com.littlebug.bean.DeviceType;

import java.util.List;

/**
 * Created by huahua
 * Date 2019/4/3 Times 19:34
 */
public interface DeviceService {
    List<DeviceType> findAllDeviceTypes();

    boolean editDeviceType(DeviceType deviceType, String deviceTypeId);

    boolean addDeviceType(DeviceType deviceType);

    boolean deleteDeviceTypeByIds(String[] ids);

    List<DeviceType> findDeviceTypeById(String deviceTypeId);

    List<DeviceType> findDeviceTypeListByName(String deviceTypeName);

    List<Device> findAllDevices();
}
