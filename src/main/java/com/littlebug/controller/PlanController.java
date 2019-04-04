package com.littlebug.controller;

import com.littlebug.bean.*;
import com.littlebug.service.PlanService;
import com.littlebug.util.tag.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/3 17:15
 * @Modified By
 */
@Controller
public class PlanController {

    @Autowired
    PlanService planService;


    @RequestMapping("order/list")
    @ResponseBody
    public List<COrder> findByPage(@Param("page")int page, @Param("rows")int rows, HttpServletRequest request){
        PageModel<COrder> pagemodel = (PageModel<COrder>) request.getAttribute("pagemodel");
        pagemodel.setPageIndex(page);
        PageModel pageModel = new PageModel();
        int start = (page - 1) * rows;
        int end = start + rows;
        List<COrder> orderList = planService.showAllOrdersByIndexs(start, end);
        int allRecords = orderList.size();
        int pages = allRecords / rows;
        pageModel.setTotalSize(allRecords);
        pagemodel.setPageSize(rows);
        pagemodel.setTotalSize(pages);
        pagemodel.setLists(orderList);
        request.setAttribute("pageModel",pageModel);
        return orderList;
    }

    @RequestMapping("order/find")
    public String turn(){
        return "order_list";
    }

//    @RequestMapping("order/find")
//    @ResponseBody
//    public List<COrder> orderfind(){
//
//
//        PageModel pageModel = new PageModel();
//        List<COrder> allOrders = planService.showAllOrdersByIndexs(1,3);
//        allOrders.add(new COrder("1","2"));
//        allOrders.add(new COrder("1","2"));
//        allOrders.add(new COrder("1","2"));
//        allOrders.add(new COrder("1","2"));
//
//
//        pageModel.setLists(allOrders);
//        pageModel.setRecordCount(allOrders.size());
//        pageModel.setTotalSize(allOrders.size());
//
//        return allOrders;
//    }



    @RequestMapping("custom/list")
    @ResponseBody
    public List<Custom> showCustomList(){
        ArrayList<Custom> list = new ArrayList<>();



        return list;
    }

    @RequestMapping("product/list")
    @ResponseBody
    public List<Product> showProductList(){
        ArrayList<Product> list = new ArrayList<>();



        return list;
    }

    @RequestMapping("work/list")
    @ResponseBody
    public List<Work> showWorkList(){
        ArrayList<Work> list = new ArrayList<>();



        return list;
    }


    @RequestMapping("manufacture/list")
    @ResponseBody
    public List<Manufacture> showManufactureList(){
        ArrayList<Manufacture> list = new ArrayList<>();



        return list;
    }


    @RequestMapping("task/list")
    @ResponseBody
    public List<Task> showTaskList(){
        ArrayList<Task> list = new ArrayList<>();



        return list;
    }
}
