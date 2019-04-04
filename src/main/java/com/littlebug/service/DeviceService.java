package com.littlebug.service;

import com.littlebug.bean.Device;
import com.littlebug.bean.DeviceType;

import java.util.List;

/**
 * Created by huahua
 * Date 2019/4/3 Times 19:34
 */
public interface DeviceService {
    List<Device> findAllDevices();

    List<DeviceType> findAllDeviceTypes();
}
