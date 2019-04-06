package com.littlebug.service.impl;

import com.littlebug.bean.*;
import com.littlebug.dao.*;
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

    @Autowired
    DeviceFaultMapper deviceFaultMapper;

    @Autowired
    DeviceCheckMapper deviceCheckMapper;

    @Autowired
    DeviceMaintainMapper deviceMaintainMapper;

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

    @Override
    public boolean addDevice(Device device) {
        String deviceStatusId = device.getDeviceStatusId();
        switch (deviceStatusId) {
            case "1":
                device.setDeviceStatus("良好");
                break;
            case "2":
                device.setDeviceStatus("故障");
                break;
            case "3":
                device.setDeviceStatus("维修");
                break;
            case "4":
                device.setDeviceStatus("报废");
                break;
        }
        int insert = deviceMapper.insert(device);
        return insert == 1;
    }

    @Override
    public boolean editDeviceById(Device device) {
        String deviceStatusId = device.getDeviceStatusId();
        switch (deviceStatusId) {
            case "1":
                device.setDeviceStatus("良好");
                break;
            case "2":
                device.setDeviceStatus("故障");
                break;
            case "3":
                device.setDeviceStatus("维修");
                break;
            case "4":
                device.setDeviceStatus("报废");
                break;
        }
        int i = deviceMapper.updateByPrimaryKeySelective(device);
        return i == 1;
    }

    @Override
    public boolean deleteDeviceByIds(String[] ids) {
        int i = deviceMapper.deleteDeviceByIds(ids);
        return i != 0;
    }

    @Override
    public List<Device> selectDeviceListByDeviceId(String deviceId) {
        List<Device> deviceList = deviceMapper.selectDeviceListByDeviceId(deviceId);
        return deviceList;
    }

    @Override
    public List<Device> selectDeviceListByDeviceName(String deviceName) {
        List<Device> deviceList = deviceMapper.selectDeviceListByDeviceName(deviceName);
        return deviceList;
    }

    @Override
    public List<Device> selectDeviceListByDeviceTypeName(String deviceTypeName) {
        List<Device> deviceList = deviceMapper.selectDeviceListByDeviceTypeName(deviceTypeName);
        return deviceList;
    }

    @Override
    public List<DeviceFault> searchDeviceFaultList() {
        List<DeviceFault> deviceFaultList = deviceFaultMapper.selectDeviceFaultList();
        return deviceFaultList;
    }

    @Override
    public boolean updateNoteByDeviceId(String deviceId, String note) {
        int i = deviceMapper.updateNoteByDeviceId(deviceId, note);
        return i == 1;
    }

    @Override
    public boolean updateDeviceFaultNote(String deviceFaultId, String deviceFaultDetail) {
        int i = deviceFaultMapper.updateDeviceFaultNote(deviceFaultId, deviceFaultDetail);
        return i == 1;
    }

    @Override
    public boolean addDeviceFault(DeviceFault deviceFault) {
        int i = deviceFaultMapper.insertSelective(deviceFault);
        return i == 1;
    }

    @Override
    public boolean editDeviceFault(DeviceFault deviceFault) {
        int i = deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
        return i == 1;
    }

    @Override
    public boolean deleteDeviceFaultList(String[] ids) {
        int i = deviceFaultMapper.deleteBatchByPrimaryKey(ids);
        return i != 0;
    }

    @Override
    public List<DeviceFault> selectDeviceFaultListById(String id) {
        List<DeviceFault> deviceFaultList = deviceFaultMapper.selectDeviceFaultListById(id);
        return deviceFaultList;
    }

    @Override
    public List<DeviceFault> selectDeviceFaultListByDeviceName(String deviceName) {
        List<DeviceFault> deviceFaultList = deviceFaultMapper.selectDeviceFaultListByDeviceName(deviceName);
        return deviceFaultList;
    }

    @Override
    public List<DeviceCheck> selectDeviceCheckList() {
        List<DeviceCheck> deviceCheckList = deviceCheckMapper.selectDeviceCheckList();
        return deviceCheckList;
    }

    @Override
    public boolean addDeviceCheck(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.insertSelective(deviceCheck);
        return i == 1;
    }

    @Override
    public boolean editDeviceCheckById(DeviceCheck deviceCheck) {
        int i = deviceCheckMapper.updateByPrimaryKeySelective(deviceCheck);
        return i == 1;
    }

    @Override
    public boolean deleteDeviceCheckList(String[] ids) {
        int i = deviceCheckMapper.deleteDeviceCheckList(ids);
        return i != 0;
    }

    @Override
    public List<DeviceCheck> selectDeviceCheckListById(String id) {
        List<DeviceCheck> deviceCheckList = deviceCheckMapper.selectDeviceCheckListById(id);
        return deviceCheckList;
    }

    @Override
    public List<DeviceCheck> selectDeviceCheckListByDeviceName(String deviceName) {
        List<DeviceCheck> deviceCheckList = deviceCheckMapper.selectDeviceCheckListByDeviceName(deviceName);
        return deviceCheckList;
    }

    @Override
    public List<DeviceMaintain> selectDeviceMaintainList() {
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.selectDeviceMaintainList();
        return deviceMaintainList;
    }

    @Override
    public boolean addDeviceMaintain(DeviceMaintain deviceMaintain) {
        int insert = deviceMaintainMapper.insert(deviceMaintain);
        return insert == 1;
    }

    @Override
    public boolean editDeviceMaintain(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.updateByPrimaryKey(deviceMaintain);
        return i == 1;
    }

    @Override
    public boolean deleteDeviceMaintainByIds(String[] ids) {
        int i = deviceMaintainMapper.deleteDeviceMaintainByIds(ids);
        return i != 0;
    }

    @Override
    public List<DeviceMaintain> selectDeviceMaintainListById(String id) {
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.selectDeviceMaintainListById(id);
        return deviceMaintainList;
    }

    @Override
    public List<DeviceMaintain> selectDeviceMaintainListByDeviceFaultId(String deviceFaultId) {
        List<DeviceMaintain> deviceMaintainList = deviceMaintainMapper.selectDeviceMaintainListByDeviceFaultId(deviceFaultId);
        return deviceMaintainList;
    }

    @Override
    public boolean updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        int i = deviceMaintainMapper.updateByPrimaryKeySelective(deviceMaintain);
        return i == 1;
    }

    @Override
    public boolean updateDeviceFault(DeviceFault deviceFault) {
        int i = deviceFaultMapper.updateByPrimaryKeySelective(deviceFault);
        return i == 1;
    }
}
