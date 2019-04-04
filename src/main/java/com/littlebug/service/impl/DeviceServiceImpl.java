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
    DeviceTypeMapper deviceTypeMapper;

    @Autowired
    DeviceMapper deviceMapper;

    @Override
    public List<DeviceType> findAllDeviceTypes() {
        List<DeviceType> deviceTypeList = deviceTypeMapper.selectAllDeviceTypes();
        return deviceTypeList;
    }

    @Override
    public boolean addDeviceType(DeviceType deviceType) {
        int insert = deviceTypeMapper.insert(deviceType);
        return insert == 1;
    }

    @Override
    public boolean editDeviceType(DeviceType deviceType, String deviceTypeId) {
        deviceType.setDeviceTypeId(deviceTypeId);
        int i = deviceTypeMapper.updateByPrimaryKeySelective(deviceType);
        return i == 1;
    }

    @Override
    public boolean deleteDeviceTypeByIds(String[] ids) {
        int i = deviceTypeMapper.deleteByIds(ids);
        return i != 0;
    }

    @Override
    public List<DeviceType> findDeviceTypeById(String deviceTypeId) {
        List<DeviceType> deviceType = deviceTypeMapper.selectById(deviceTypeId);
        return deviceType;
    }

    @Override
    public List<DeviceType> findDeviceTypeListByName(String deviceTypeName) {
        List<DeviceType> deviceTypeList = deviceTypeMapper.selectByName(deviceTypeName);
        return deviceTypeList;
    }

    @Override
    public List<Device> findAllDevices() {
        List<Device> deviceList = deviceMapper.selectAllDevices();
        return deviceList;
    }
}
