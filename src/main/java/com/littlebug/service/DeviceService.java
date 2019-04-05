package com.littlebug.service;

import com.littlebug.bean.*;

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

    boolean addDevice(Device device);

    boolean editDeviceById(Device device);

    boolean deleteDeviceByIds(String[] ids);

    List<Device> selectDeviceListByDeviceId(String deviceId);

    List<Device> selectDeviceListByDeviceName(String deviceName);

    List<Device> selectDeviceListByDeviceTypeName(String deviceTypeName);

    List<DeviceFault> searchDeviceFaultList();

    boolean updateNoteByDeviceId(String deviceId, String note);

    boolean updateDeviceFaultNote(String deviceFaultId, String deviceFaultDetail);

    boolean updateDeviceFault(DeviceFault deviceFault);

    boolean addDeviceFault(DeviceFault deviceFault);

    boolean editDeviceFault(DeviceFault deviceFault);

    boolean deleteDeviceFaultList(String[] ids);

    List<DeviceFault> selectDeviceFaultListById(String id);

    List<DeviceFault> selectDeviceFaultListByDeviceName(String deviceName);

    List<DeviceCheck> selectDeviceCheckList();

    boolean addDeviceCheck(DeviceCheck deviceCheck);

    boolean editDeviceCheckById(DeviceCheck deviceCheck);

    boolean deleteDeviceCheckList(String[] ids);

    List<DeviceCheck> selectDeviceCheckListById(String id);

    List<DeviceCheck> selectDeviceCheckListByDeviceName(String deviceName);

    List<DeviceMaintain> selectDeviceMaintainList();

    boolean addDeviceMaintain(DeviceMaintain deviceMaintain);

    boolean editDeviceMaintain(DeviceMaintain deviceMaintain);

    boolean deleteDeviceMaintainByIds(String[] ids);

    List<DeviceMaintain> selectDeviceMaintainListById(String id);

    List<DeviceMaintain> selectDeviceMaintainListByDeviceFaultId(String deviceFaultId);

    boolean updateDeviceMaintain(DeviceMaintain deviceMaintain);
}
