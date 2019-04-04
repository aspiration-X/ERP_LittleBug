package com.littlebug.service.impl;

import com.littlebug.bean.Device;
import com.littlebug.bean.DeviceType;
import com.littlebug.dao.DeviceMapper;
import com.littlebug.dao.DeviceTypeMapper;
import com.littlebug.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huahua
 * Date 2019/4/3 Times 19:35
 */
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceMapper deviceMapper;

    @Autowired
    DeviceTypeMapper deviceTypeMapper;
    @Override
    public List<Device> findAllDevices() {
        List<Device> deviceList = deviceMapper.selectAllDevices();
        return deviceList;
    }

    @Override
    public List<DeviceType> findAllDeviceTypes() {
        List<DeviceType> deviceTypeList = deviceTypeMapper.selectAllDeviceTypes();
        return deviceTypeList;
    }
}
