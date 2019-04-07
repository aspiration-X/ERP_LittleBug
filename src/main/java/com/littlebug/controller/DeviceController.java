package com.littlebug.controller;

import com.github.pagehelper.PageInfo;
import com.littlebug.bean.*;
import com.littlebug.service.DeviceService;
import com.littlebug.util.DuplicatedCodeUtil;
import com.littlebug.util.PageWraper;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by huahua
 * Date 2019/4/3 Times 19:29
 */
@Controller
public class DeviceController {
    @Autowired
    DeviceService deviceService;

    @RequestMapping("/device/deviceType")
    public String deviceType1() {
        return "deviceType";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public PageWraper<DeviceType> deviceType2(int page, int rows) {
        PageInfo<DeviceType> pageInfo = deviceService.findAllDeviceTypes(page, rows);
        PageWraper<DeviceType> deviceTypePageWraper = new PageWraper<>((int) (pageInfo.getTotal()), pageInfo.getList());
        return deviceTypePageWraper;
    }

    @RequestMapping("deviceType/get_data")
    @ResponseBody
    public List<DeviceType> deviceType3() {
        List<DeviceType> deviceType = deviceService.findAllDeviceTypeList();
        return deviceType;
    }


    @RequestMapping("*/*_judge")
    @ResponseBody
    public UserMessage judge() {
        return new UserMessage();
    }

    @RequestMapping("deviceType/add")
    public String addDeviceType2() {
        return "deviceType_add";
    }

    @RequestMapping("/deviceType/insert")
    @ResponseBody
    public UserMessage addDeviceType3(@Valid DeviceType deviceType, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            String defaultMessage = fieldError.getDefaultMessage();
            UserMessage userMessage = new UserMessage();
            userMessage.setMsg(defaultMessage);
            return userMessage;
        }
        boolean b = deviceService.addDeviceType(deviceType);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceType/edit")
    public String deviceTypeEdit1() {
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/update")
    @ResponseBody
    public UserMessage deviceTypeEdit2(DeviceType deviceType, String deviceTypeId) {
        boolean b = deviceService.editDeviceType(deviceType, deviceTypeId);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceType/update_all")
    @ResponseBody
    public UserMessage deviceTypeEdit3(DeviceType deviceType, String deviceTypeId) {
        boolean b = deviceService.editDeviceType(deviceType, deviceTypeId);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public UserMessage deviceTypeDelete(String ids) {
        String[] strings = ids.split(",");
        boolean b = deviceService.deleteDeviceTypeByIds(strings);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public List<DeviceType> searchDeviceTypeListById(String searchValue) {
        List<DeviceType> deviceType = deviceService.findDeviceTypeById(searchValue);
        return deviceType;
    }

    @RequestMapping("deviceType/get/{deviceTypeId}")
    @ResponseBody
    public DeviceType getDeviceTypeListById(@PathVariable("deviceTypeId") String deviceTypeId) {
        List<DeviceType> deviceType = deviceService.findDeviceTypeById(deviceTypeId);
        return deviceType.get(0);
    }

    @RequestMapping("deviceType/search_deviceType_by_deviceTypeName")
    @ResponseBody
    public List<DeviceType> searchDeviceTypeListByName(String searchValue) {
        List<DeviceType> deviceType = deviceService.findDeviceTypeListByName(searchValue);
        return deviceType;
    }

    @RequestMapping("/device/deviceList")
    public String deviceList1() {
        return "deviceList";
    }

    @RequestMapping("/deviceList/list")
    @ResponseBody
    public List<Device> deviceList2() {
        List<Device> deviceList = deviceService.findAllDevices();
        return deviceList;
    }

    @RequestMapping("deviceList/add")
    public String addDevice1() {
        return "deviceList_add";
    }

    @RequestMapping("deviceList/insert")
    @ResponseBody
    public UserMessage addDevice2(Device device) {
        boolean b = deviceService.addDevice(device);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceList/edit")
    public String editDevice1() {
        return "deviceList_edit";
    }

    @RequestMapping("deviceList/update")
    @ResponseBody
    public UserMessage editDevice2(Device device) {
        boolean b = deviceService.editDeviceById(device);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceList/delete_batch")
    @ResponseBody
    public UserMessage deleteDeviceByIds(String ids) {
        String[] strings = ids.split(",");
        boolean b = deviceService.deleteDeviceByIds(strings);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceList/search_device_by_deviceId")
    @ResponseBody
    public List<Device> selectDeviceListByDeviceId(String searchValue) {
        List<Device> deviceList = deviceService.selectDeviceListByDeviceId(searchValue);
        return deviceList;
    }

    @RequestMapping("deviceList/search_device_by_deviceName")
    @ResponseBody
    public List<Device> selectDeviceListByDeviceName(String searchValue) {
        List<Device> deviceList = deviceService.selectDeviceListByDeviceName(searchValue);
        return deviceList;
    }

    @RequestMapping("deviceList/search_device_by_deviceTypeName")
    @ResponseBody
    public List<Device> selectDeviceListByDeviceTypeName(String searchValue) {
        List<Device> deviceList = deviceService.selectDeviceListByDeviceTypeName(searchValue);
        return deviceList;
    }

    @RequestMapping("deviceList/update_note")
    @ResponseBody
    public UserMessage updateDeviceNote(String deviceId, String note) {
        boolean b = deviceService.updateNoteByDeviceId(deviceId, note);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("device/deviceFault")
    public String searchDeviceFaultList1() {
        return "deviceFault";
    }

    @RequestMapping("deviceFault/list")
    @ResponseBody
    public List<DeviceFault> searchDeviceFaultList2() {
        List<DeviceFault> deviceFaultList = deviceService.searchDeviceFaultList();
        return deviceFaultList;
    }

    @RequestMapping("deviceList/get/{deviceId}")
    @ResponseBody
    public Device searchDeviceById(@PathVariable("deviceId") String deviceId) {
        List<Device> deviceList = deviceService.selectDeviceListByDeviceId(deviceId);
        return deviceList.get(0);
    }

    @RequestMapping("deviceFault/update_note")
    @ResponseBody
    public UserMessage updateDeviceFaultNote(String deviceFaultId, String deviceFaultDetail) {
        boolean b = deviceService.updateDeviceFaultNote(deviceFaultId, deviceFaultDetail);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceList/update_all")
    @ResponseBody
    public UserMessage updateDeviceByDeviceId(Device device) {
        boolean b = deviceService.editDeviceById(device);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceFault/add")
    public String addDeviceFault1() {
        return "deviceFault_add";
    }

    @RequestMapping("deviceList/get_data")
    @ResponseBody
    public List<Device> getDeviceList() {
        List<Device> deviceList = deviceService.findAllDevices();
        return deviceList;
    }

    @RequestMapping("deviceFault/insert")
    @ResponseBody
    public UserMessage addDeviceFault2(DeviceFault deviceFault) {
        boolean b = deviceService.addDeviceFault(deviceFault);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceFault/edit")
    public String editDeviceFault1() {
        return "deviceFault_edit";
    }

    @RequestMapping("deviceFault/update")
    @ResponseBody
    public UserMessage editDeviceFault2(DeviceFault deviceFault) {
        boolean b = deviceService.editDeviceFault(deviceFault);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceFault/delete_batch")
    @ResponseBody
    public UserMessage deleteDeviceFaultList(String ids) {
        String[] strings = ids.split(",");
        boolean b = deviceService.deleteDeviceFaultList(strings);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceFault/search_deviceFault_by_deviceFaultId")
    @ResponseBody
    public List<DeviceFault> searchDeviceFaultById(String searchValue) {
        List<DeviceFault> deviceFaultList = deviceService.selectDeviceFaultListById(searchValue);
        return deviceFaultList;
    }

    @RequestMapping("deviceFault/search_deviceFault_by_deviceName")
    @ResponseBody
    public List<DeviceFault> searchDeviceFaultByDeviceName(String searchValue) {
        List<DeviceFault> deviceFaultList = deviceService.selectDeviceFaultListByDeviceName(searchValue);
        return deviceFaultList;
    }

    @RequestMapping("device/deviceCheck")
    public String deviceCheck() {
        return "deviceCheck";
    }

    @RequestMapping("deviceCheck/list")
    @ResponseBody
    public List<DeviceCheck> findDeviceCheckList() {
        List<DeviceCheck> deviceCheckList = deviceService.selectDeviceCheckList();
        return deviceCheckList;
    }

    @RequestMapping("deviceCheck/add")
    public String addDeviceCheck1() {
        return "deviceCheck_add";
    }

    @RequestMapping("deviceCheck/insert")
    @ResponseBody
    public UserMessage addDeviceCheck2(DeviceCheck deviceCheck) {
        boolean b = deviceService.addDeviceCheck(deviceCheck);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceCheck/edit")
    public String editDeviceCheck1() {
        return "deviceCheck_edit";
    }

    @RequestMapping("deviceCheck/update")
    @ResponseBody
    public UserMessage editDeviceCheck2(DeviceCheck deviceCheck) {
        boolean b = deviceService.editDeviceCheckById(deviceCheck);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceCheck/delete_batch")
    @ResponseBody
    public UserMessage deleteDeviceCheckList(String ids) {
        String[] strings = ids.split(",");
        boolean b = deviceService.deleteDeviceCheckList(strings);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceCheckId")
    @ResponseBody
    public List<DeviceCheck> searchDeviceCheckById(String searchValue) {
        List<DeviceCheck> deviceCheckList = deviceService.selectDeviceCheckListById(searchValue);
        return deviceCheckList;
    }

    @RequestMapping("deviceCheck/search_deviceCheck_by_deviceName")
    @ResponseBody
    public List<DeviceCheck> searchDeviceCheckByDeviceName(String searchValue) {
        List<DeviceCheck> deviceCheckList = deviceService.selectDeviceCheckListByDeviceName(searchValue);
        return deviceCheckList;
    }

    @RequestMapping("deviceCheck/update_note")
    @ResponseBody
    public UserMessage updateDeviceCheck(DeviceCheck deviceCheck) {
        boolean b = deviceService.editDeviceCheckById(deviceCheck);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("device/deviceMaintain")
    public String deviceMaintain() {
        return "deviceMaintain";
    }

    @RequestMapping("deviceMaintain/list")
    @ResponseBody
    public List<DeviceMaintain> searchDeviceMaintainList() {
        List<DeviceMaintain> deviceMaintainList = deviceService.selectDeviceMaintainList();
        return deviceMaintainList;
    }

    @RequestMapping("deviceMaintain/add")
    public String addDeviceMaintain1() {
        return "deviceMaintain_add";
    }

    @RequestMapping("deviceMaintain/insert")
    @ResponseBody
    public UserMessage addDeviceMaintain2(DeviceMaintain deviceMaintain) {
        boolean b = deviceService.addDeviceMaintain(deviceMaintain);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceMaintain/edit")
    public String editDeviceMaintain() {
        return "deviceMaintain_edit";
    }

    @RequestMapping("deviceMaintain/update")
    @ResponseBody
    public UserMessage editDeviceMaintain(DeviceMaintain deviceMaintain) {
        boolean b = deviceService.editDeviceMaintain(deviceMaintain);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceMaintain/delete_batch")
    @ResponseBody
    public UserMessage deletetDeviceMaintainByIds(String ids) {
        String[] strings = ids.split(",");
        boolean b = deviceService.deleteDeviceMaintainByIds(strings);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceFault/update_all")
    @ResponseBody
    public UserMessage updateDeviceFault(DeviceFault deviceFault) {
        boolean b = deviceService.updateDeviceFault(deviceFault);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceMaintain/search_deviceMaintain_by_deviceMaintainId")
    @ResponseBody
    public List<DeviceMaintain> searchDeviceMaintainById(String searchValue) {
        List<DeviceMaintain> deviceMaintainList = deviceService.selectDeviceMaintainListById(searchValue);
        return deviceMaintainList;
    }

    @RequestMapping("deviceCheck/deviceMaintain/search_deviceMaintain_by_deviceFaultId")
    @ResponseBody
    public List<DeviceMaintain> searchDeviceMaintainByDeviceFaultId(String searchValue) {
        List<DeviceMaintain> deviceMaintainList = deviceService.selectDeviceMaintainListByDeviceFaultId(searchValue);
        return deviceMaintainList;
    }

    @RequestMapping("deviceMaintain/update_note")
    @ResponseBody
    public UserMessage updateDeviceMaintain(DeviceMaintain deviceMaintain) {
        boolean b = deviceService.updateDeviceMaintain(deviceMaintain);
        return DuplicatedCodeUtil.consequenceMessageReturn(b);
    }

    @RequestMapping("deviceFault/get/{deviceFaultId}")
    @ResponseBody
    public DeviceFault getDeviceFault(@PathVariable("deviceFaultId") String deviceFaultId) {
        List<DeviceFault> deviceFaultList = deviceService.selectDeviceFaultListById(deviceFaultId);
        return deviceFaultList.get(0);
    }


}
