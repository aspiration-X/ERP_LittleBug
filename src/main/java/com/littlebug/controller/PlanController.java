package com.littlebug.controller;

import com.littlebug.bean.*;
import com.littlebug.service.PlanService;
import com.littlebug.util.UserMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    /*------------------------------------------------ order ---------------------------------------------------*/
    @RequestMapping("order/list")
    @ResponseBody
    public List<COrder> findByPage(@Param("page") int page, @Param("rows") int rows, HttpServletRequest request) {
        int start = (page - 1) * rows;
        int end = start + rows;
        List<COrder> orderList = planService.showAllOrdersByIndexs(start, end);
        int allRecords = orderList.size();
        int pages = allRecords / rows;
        return orderList;
    }

    @RequestMapping("order/find")
    public String goOrderList() {
        return "order_list";
    }


    @RequestMapping("order/delete_batch")
    @ResponseBody
    public UserMessage deleteOrderByIds(@Param("ids") String[] ids) {
        boolean deleteBatchOrders = planService.deleteBatchOrders(ids);
        UserMessage userMessage = new UserMessage();
        if (deleteBatchOrders){
            userMessage.setMsg("OK");
            userMessage.setStatus(200);
        }else {
            userMessage.setMsg("FALSE");
            userMessage.setStatus(500);
        }
        return userMessage;
    }

//    @RequestMapping("order/edit_judge")
//    @ResponseBody
//    public String edit_judge(){
////        return "redirect:order/edit";
//        return "{}";
//    }

    @RequestMapping("**/*_judge")
    @ResponseBody
    public String judge() {
        return "{}";
    }

//    @RequestMapping("order/add_judge")
//    @ResponseBody
//    public String add_judge(){
//        return "{}";
//    }

    @RequestMapping("order/edit")
    public String goEditOrderPage() {
        return "order_edit";
    }


    @RequestMapping("order/add")
    public String goAddOrderPage() {
        return "order_add";
    }

//    @RequestMapping(value = "order/update_all",
//            method = RequestMethod.POST,
//            produces = {"application/json;charset=UTF-8"},
//            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    @ResponseBody
//    public String edit(COrder order, HttpServletRequest request,  @RequestBody String apps) {
//        request.getAttribute("order");
//        planService.updateOrder(order);
//        String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
//        return BaseResponse.success();
//        return "";
//    }


    @RequestMapping(value = "order/update_all")
    @ResponseBody
    public UserMessage editOrder(COrder order) {
        planService.updateOrder(order);
        UserMessage userMessage = new UserMessage();
        userMessage.setStatus(200);
        userMessage.setMsg("OK");
        return userMessage;
    }


    @RequestMapping("order/insert")
    @ResponseBody
    public UserMessage addOrder(COrder order) {
        boolean addOrder = planService.addOrder(order);
        UserMessage userMessage = new UserMessage();
        if (addOrder){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }

    @RequestMapping("order/search_order_by_orderId")
    public List<COrder> searchOrderByOrderId(@Param("searchValue") String searchValue,
                                             @Param("page") int page, @Param("rows") int rows){

        List<COrder> orders = planService.selectOrderById(searchValue, page, rows);
        return orders;
    }

    @RequestMapping("order/search_order_by_orderCustom")
    public List<COrder> searchOrderByOrderCustom(@Param("searchValue") String searchValue,
                                             @Param("page") int page, @Param("rows") int rows){

        List<COrder> orders = planService.selectOrderByCustom(searchValue, page, rows);
        return orders;
    }

    @RequestMapping("order/search_order_by_orderProduct")
    public List<COrder> searchOrderByOrderProduct(@Param("searchValue") String searchValue,
                                             @Param("page") int page, @Param("rows") int rows){

        List<COrder> orders = planService.selectOrderByProduct(searchValue, page, rows);
        return orders;
    }




    /*----------------------------------------------------- product ---------------------------------------------*/


    @ResponseBody
    @RequestMapping("product/get_data")
    public List<Product> getProductData() {
        List<Product> productList = planService.showProductList();

        return productList;
    }

    @ResponseBody
    @RequestMapping("product/get")
    public List<Product> getProductInfoById() {
        List<Product> productList = planService.showProductList();

        return productList;
    }







    /*------------------------------------------------------- custom -------------------------------------------*/

    @ResponseBody
    @RequestMapping("custom/get_data")
    public List<Custom> getCustomData() {
        List<Custom> customList = planService.showCustomList();
        return customList;
    }


    @RequestMapping("custom/list")
    @ResponseBody
    public List<Custom> showCustomList() {
        ArrayList<Custom> list = new ArrayList<>();


        return list;
    }

    @RequestMapping("product/list")
    @ResponseBody
    public List<Product> showProductList() {
        ArrayList<Product> list = new ArrayList<>();


        return list;
    }

    @RequestMapping("work/list")
    @ResponseBody
    public List<Work> showWorkList() {
        ArrayList<Work> list = new ArrayList<>();


        return list;
    }


    @RequestMapping("manufacture/list")
    @ResponseBody
    public List<Manufacture> showManufactureList() {
        ArrayList<Manufacture> list = new ArrayList<>();


        return list;
    }


    @RequestMapping("task/list")
    @ResponseBody
    public List<Task> showTaskList() {
        ArrayList<Task> list = new ArrayList<>();


        return list;
    }
}
