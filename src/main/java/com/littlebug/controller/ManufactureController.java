package com.littlebug.controller;

import com.littlebug.bean.Manufacture;
import com.littlebug.bean.Work;
import com.littlebug.dao.COrderMapper;
import com.littlebug.service.ManufactureService;
import com.littlebug.service.PlanService;
import com.littlebug.service.TechnologyService;
import com.littlebug.util.PageWraper;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/6 2:32
 * @Modified By
 */
public class ManufactureController {

    @Autowired
    PlanService planService;

    @Autowired
    TechnologyService technologyService;

    @Autowired
    ManufactureService manufactureService;


    @RequestMapping("manufacture/list")
    @ResponseBody
    public PageWraper<Manufacture> findManufactureByPage(@RequestParam("page") int page,
                                                  @RequestParam("rows") int rows) {
        PageWraper<Manufacture> pageWraper = new PageWraper<>();
        List<Manufacture> manufactureList = manufactureService.showAllManufacturesByIndexs(page, rows);
        int manufactureAmount = manufactureService.countAllManufactures();

        pageWraper.setRows(manufactureList);
        pageWraper.setTotal(manufactureAmount);
        return pageWraper;
    }


    @RequestMapping("manufacture/insert")
    @ResponseBody
    public UserMessage addProduct(Manufacture manufacture) {
        boolean addManufacture = manufactureService.addManufacture(manufacture);
        UserMessage userMessage = new UserMessage();
        if (addManufacture){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }



    @RequestMapping(value = "manufacture/delete_batch",
            method= RequestMethod.POST,
            consumes="application/x-www-form-urlencoded")
    @ResponseBody
    public UserMessage deleteBatchManufactures(String[] ids) {
        boolean deleteBatchManufactures = manufactureService.deleteBatchManufactures(ids);
        UserMessage userMessage = new UserMessage();
        if (deleteBatchManufactures){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }


    @RequestMapping("manufacture/update_all")
    @ResponseBody
    public UserMessage updateManufacture(Manufacture manufacture) {


        boolean updateManufacture = manufactureService.updateManufacture(manufacture);
        UserMessage userMessage = new UserMessage();
        if (updateManufacture){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;

    }


    /************************ 以下3个方法可以使用正则表达式优化 **************************** */

    @RequestMapping("manufacture/search_manufacture_by_manufactureSn")
    @ResponseBody
    public PageWraper<Manufacture> searchManufactureByManufactureId(Manufacture manufacture,
                                               @RequestParam("page") int page,
                                               @RequestParam("rows") int rows) {
        PageWraper<Manufacture> pageWraper = new PageWraper<>();
        List<Manufacture> manufactureList = manufactureService.selectManufacturesOnCondition(manufacture, page, rows);
        int manufacturesAmount = manufactureService.countAllManufacturesOnCondition(manufacture);
        pageWraper.setRows(manufactureList);
        pageWraper.setTotal(manufacturesAmount);
        return pageWraper;

    }

    @RequestMapping("manufacture/search_manufacture_by_manufactureOrderId")
    @ResponseBody
    public PageWraper<Manufacture> searchManufactureByManufactureProduct(Manufacture manufacture,
                                                    @RequestParam("page") int page,
                                                    @RequestParam("rows") int rows) {
        PageWraper<Manufacture> pageWraper = new PageWraper<>();
        List<Manufacture> manufactureList = manufactureService.selectManufacturesOnCondition(manufacture, page, rows);
        int manufacturesAmount = manufactureService.countAllManufacturesOnCondition(manufacture);
        pageWraper.setRows(manufactureList);
        pageWraper.setTotal(manufacturesAmount);
        return pageWraper;

    }

    @RequestMapping("manufacture/search_manufacture_by_manufactureTechnologyName")
    @ResponseBody
    public PageWraper<Manufacture> searchManufactureByManufactureDevice(Manufacture manufacture,
                                                   @RequestParam("page") int page,
                                                   @RequestParam("rows") int rows) {
        PageWraper<Manufacture> pageWraper = new PageWraper<>();
        List<Manufacture> manufactureList = manufactureService.selectManufacturesOnCondition(manufacture, page, rows);
        int manufacturesAmount = manufactureService.countAllManufacturesOnCondition(manufacture);
        pageWraper.setRows(manufactureList);
        pageWraper.setTotal(manufacturesAmount);
        return pageWraper;

    }




    @RequestMapping("manufacture/search_Manufacture_by_ManufactureProcess")
    @ResponseBody
    public PageWraper<Manufacture> searchManufactureByManufactureProcess(Manufacture manufacture,
                                                    @RequestParam("page") int page,
                                                    @RequestParam("rows") int rows) {
        PageWraper<Manufacture> pageWraper = new PageWraper<>();
        List<Manufacture> manufactureList = manufactureService.selectManufacturesOnCondition(manufacture, page, rows);
        int manufacturesAmount = manufactureService.countAllManufacturesOnCondition(manufacture);
        pageWraper.setRows(manufactureList);
        pageWraper.setTotal(manufacturesAmount);
        return pageWraper;

    }


    @ResponseBody
    @RequestMapping("manufacture/get_data")
    public List<Manufacture> getManufactureData() {
        List<Manufacture> manufactureList = manufactureService.showManufactureList();

        return manufactureList;
    }

    @ResponseBody
    @RequestMapping("manufacture/get/{manufactureId}")
    public Manufacture selectManufactureByManufactureId(@PathVariable("manufactureId") String manufactureId) {
        return manufactureService.selectManufactureByManufactureId(manufactureId);
    }




}
