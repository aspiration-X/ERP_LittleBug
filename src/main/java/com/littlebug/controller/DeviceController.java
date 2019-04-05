package com.littlebug.controller;

import com.littlebug.bean.Device;
import com.littlebug.bean.DeviceType;
import com.littlebug.service.DeviceService;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public List<DeviceType> deviceType2() {
        List<DeviceType> deviceType = deviceService.findAllDeviceTypes();
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
    public UserMessage addDeviceType3(DeviceType deviceType) {
        boolean b = deviceService.addDeviceType(deviceType);
        UserMessage userMessage = new UserMessage();
        if (b) {
            userMessage.setMsg("ok");
            userMessage.setStatus(200);
        }
        return userMessage;
    }

    @RequestMapping("deviceType/edit")
    public String deviceTypeEdit1() {
        return "deviceType_edit";
    }

    @RequestMapping("deviceType/update")
    @ResponseBody
    public UserMessage deviceTypeEdit2(DeviceType deviceType, String deviceTypeId) {
        boolean b = deviceService.editDeviceType(deviceType, deviceTypeId);
        UserMessage userMessage = new UserMessage();
        if (b) {
            userMessage.setMsg("ok");
            userMessage.setStatus(200);
        }
        return userMessage;
    }

    @RequestMapping("deviceType/delete_batch")
    @ResponseBody
    public UserMessage deviceTypeDelete(String ids) {
        String[] strings = ids.split(",");
        boolean b = deviceService.deleteDeviceTypeByIds(strings);
        UserMessage userMessage = new UserMessage();
        if (b) {
            userMessage.setMsg("ok");
            userMessage.setStatus(200);
        }
        return userMessage;
    }

    @RequestMapping("deviceType/search_deviceType_by_deviceTypeId")
    @ResponseBody
    public List<DeviceType> searchDeviceTypeListById(String searchValue) {
        List<DeviceType> deviceType = deviceService.findDeviceTypeById(searchValue);
        return deviceType;
    }

    @RequestMapping("deviceType/get")
    @ResponseBody
    public List<DeviceType> getDeviceTypeListById(String deviceTypeId) {
        List<DeviceType> deviceType = deviceService.findDeviceTypeById(deviceTypeId);
        return deviceType;
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


}
