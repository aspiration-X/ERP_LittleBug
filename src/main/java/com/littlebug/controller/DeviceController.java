package com.littlebug.controller;

import com.littlebug.bean.Device;
import com.littlebug.bean.DeviceType;
import com.littlebug.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        /*HttpSession session = request.getSession();
        ArrayList<String> sysPermissionList = new ArrayList<>();
        sysPermissionList.add("deviceType:add");
        sysPermissionList.add("deviceType:edit");
        sysPermissionList.add("deviceType:delete");
        session.setAttribute("sysPermissionList", sysPermissionList);*/
        return "deviceType";
    }

    @RequestMapping("deviceType/list")
    @ResponseBody
    public List<DeviceType> deviceType2() {
        List<DeviceType> deviceType = deviceService.findAllDeviceTypes();
        return deviceType;
    }

    @RequestMapping("deviceType/add_judge")
    public String addDeviceType1() {
        return "deviceType_add";
    }

    @RequestMapping("deviceType/add")
    public String addDeviceType2() {
        return "deviceType_add";
    }

    @RequestMapping("/deviceType/insert")
    public String addDeviceType3() {
        return "deviceType_add";
    }

    @RequestMapping("/device/deviceList")
    public String deviceList1() {
        return "deviceList";
    }

    @RequestMapping("/deviceList/list")
    @ResponseBody
    public List<Device> deviceList2(Model model) {
        List<Device> deviceList = deviceService.findAllDevices();
        return deviceList;
    }
}
