package com.littlebug.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.littlebug.bean.*;
import com.littlebug.service.PlanService;
import com.littlebug.util.PageWraper;
import com.littlebug.util.UserMessage;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

/*----------------------------------------------通用处理-------------------------------------------------*/


    /*注意： 其他以find 作为路径结尾的请求可能也会被此方法拦截*/

    /**
     * 通用匹配前往订单模块各子模块find页面的请求
     * @param application
     * @return
     */
    @RequestMapping("/{application}/find")
    public String goToFindPage(@PathVariable("application") String application){
        String resultPage = "";
        switch (application){
            case "order":
                resultPage = "order_list";
                break;
            case "custom":
                resultPage = "custom_list";
                break;
            case "product":
                resultPage = "product_list";
                break;
            case "work":
                resultPage = "work_list";
                break;
            case "manufacture":
                resultPage = "manufacture_list";
                break;
            case "task":
                resultPage = "task_list";
                break;
            default:
                break;
        }
        return resultPage;
    }

    /**
     * 通用匹配前往订单模块各子模块edit页面的请求
     * @param application
     * @return
     */
    @RequestMapping("/{application}/edit")
    public String goToEditPage(@PathVariable("application") String application){
        String resultPage = "";
        switch (application){
            case "order":
                resultPage = "order_edit";
                break;
            case "custom":
                resultPage = "custom_edit";
                break;
            case "product":
                resultPage = "product_edit";
                break;
            case "work":
                resultPage = "work_edit";
                break;
            case "manufacture":
                resultPage = "manufacture_edit";
                break;
            case "task":
                resultPage = "task_edit";
                break;
            default:
                break;
        }

        return resultPage;
    }


    /**
     * 通用匹配前往订单模块各子模块add页面的请求
     * @param application
     * @return
     */
    @RequestMapping("/{application}/add")
    public String goToAddPage(@PathVariable("application") String application){
        String resultPage = "";
        switch (application){
            case "order":
                resultPage = "order_add";
                break;
            case "custom":
                resultPage = "custom_add";
                break;
            case "product":
                resultPage = "product_add";
                break;
            case "work":
                resultPage = "work_add";
                break;
            case "manufacture":
                resultPage = "manufacture_add";
                break;
            case "task":
                resultPage = "task_add";
                break;
            default:
                break;
        }

        return resultPage;
    }




    /*------------------------------------------------ order ---------------------------------------------------*/


    @RequestMapping("order/list")
    @ResponseBody
    public List<COrder> findByPage(@RequestParam("page") int page, @RequestParam("rows") int rows) {

        PageWraper<COrder> pageWraper = new PageWraper<>();

        int start = (page - 1) * rows;
        int end = start + rows;
        List<COrder> orderList = planService.showAllOrdersByIndexs(start, end);
        int allRecords = orderList.size();

        int pages = allRecords / rows;
        pageWraper.setRows(orderList);
        pageWraper.setTotal(allRecords);


        Page page1 = PageHelper.startPage(0, 3);
//        Page<COrder>


        Page<COrder> pageHelper = new Page<>();
        pageHelper.getResult();
        return orderList;
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

    @ResponseBody
    @RequestMapping("order/get_data")
    public List<COrder> getOrderData(String id) {
        List<COrder> orderList = planService.showALLOrders();
        return orderList;
    }


//    @ResponseBody
//    @RequestMapping("order/get/{orderId}")
//    public COrder getOrder(@PathVariable("orderId") String orderId) {
//        COrder order = planService.selectOrderByOrderId(orderId);
//        return order;
//    }


    @ResponseBody
    @RequestMapping("order/get/{orderId}")
    public COrder selectOrderByOrderId(@PathVariable("orderId") String orderId) {
        return planService.selectOrderByOrderId(orderId);
    }



    @RequestMapping("order/edit")
    public String goEditOrderPage() {
        return "order_edit";
    }


    @RequestMapping("order/add")
    public String goAddOrderPage() {
        return "order_add";
    }


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


    @ResponseBody
    @RequestMapping("order/search_order_by_orderId")
    public List<COrder> searchOrderByOrderId(String searchValue,
                                             int page,  int rows){

        List<COrder> orders = planService.selectOrderById(searchValue, page, rows);
        return orders;
    }

    @ResponseBody
    @RequestMapping("order/search_order_by_orderCustom")
    public List<COrder> searchOrderByOrderCustom(String searchValue,
                                             int page, int rows){

        List<COrder> orders = planService.selectOrderByCustom(searchValue, page, rows);
        return orders;
    }
    @ResponseBody
    @RequestMapping("order/search_order_by_orderProduct")
    public List<COrder> searchOrderByOrderProduct( String searchValue,
                                            int page, int rows){

        List<COrder> orders = planService.selectOrderByProduct(searchValue, page, rows);
        return orders;
    }




    /*----------------------------------------------------- product ---------------------------------------------*/



    @RequestMapping("product/list")
    @ResponseBody
    public PageWraper<Product> findProductByPage(@RequestParam("page") int page,
                                               @RequestParam("rows") int rows) {
        PageWraper<Product> pageWraper = new PageWraper<>();
        List<Product> productList = planService.showAllProductsByIndexs(page, rows);
        int productAmount = planService.countAllProducts();
        pageWraper.setRows(productList);
        pageWraper.setTotal(productAmount);
        return pageWraper;
    }


    @RequestMapping("product/insert")
    @ResponseBody
    public UserMessage addProduct(Product product) {
        boolean addProduct = planService.addProduct(product);
        UserMessage userMessage = new UserMessage();
        if (addProduct){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }



    @RequestMapping(value = "product/delete_batch",
            method=RequestMethod.POST,
            consumes="application/x-www-form-urlencoded")
    @ResponseBody
    public UserMessage deleteBatchProduct(String[] ids) {
        boolean deleteBatchProducts = planService.deleteBatchProducts(ids);
        UserMessage userMessage = new UserMessage();
        if (deleteBatchProducts){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }


    @RequestMapping("product/update_all")
    @ResponseBody
    public UserMessage updateProduct(Product product) {


        boolean addProduct = planService.updateProduct(product);
        UserMessage userMessage = new UserMessage();
        if (addProduct){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;

    }



    @RequestMapping("product/search_product_by_productId")
    @ResponseBody
    public PageWraper<Product> searchProductByProductName(Product product,
                                                       @RequestParam("page") int page,
                                                       @RequestParam("rows") int rows) {
        PageWraper<Product> pageWraper = new PageWraper<>();
        List<Product> productList = planService.selectProductsOnCondition(product, page, rows);
        int productsAmount = planService.countAllProductsOnCondition(product);
        pageWraper.setRows(productList);
        pageWraper.setTotal(productsAmount);
        return pageWraper;

    }

    @RequestMapping("product/search_product_by_productName")
    @ResponseBody
    public PageWraper<Product> searchProductByProductId(Product product,
                                                     @RequestParam("page") int page,
                                                     @RequestParam("rows") int rows) {
        PageWraper<Product> pageWraper = new PageWraper<>();
        List<Product> productList = planService.selectProductsOnCondition(product, page, rows);
        int productsAmount = planService.countAllProductsOnCondition(product);
        pageWraper.setRows(productList);
        pageWraper.setTotal(productsAmount);
        return pageWraper;

    }

    @RequestMapping("product/search_product_by_productType")
    @ResponseBody
    public PageWraper<Product> searchProductByProductType(Product product,
                                                         @RequestParam("page") int page,
                                                         @RequestParam("rows") int rows) {
        PageWraper<Product> pageWraper = new PageWraper<>();
        List<Product> productList = planService.selectProductsOnCondition(product, page, rows);
        int productsAmount = planService.countAllProductsOnCondition(product);
        pageWraper.setRows(productList);
        pageWraper.setTotal(productsAmount);
        return pageWraper;

    }



    @ResponseBody
    @RequestMapping("product/get_data")
    public List<Product> getProductData() {
        List<Product> productList = planService.showProductList();

        return productList;
    }

    @ResponseBody
    @RequestMapping("product/get/{productId}")
    public Product selectProductByProductId(@PathVariable("productId") String productId) {
        return planService.selectProductByProductId(productId);
    }







    /*------------------------------------------------------- custom -------------------------------------------*/


    @RequestMapping("custom/list")
    @ResponseBody
    public PageWraper<Custom> findCustomByPage(@RequestParam("page") int page,
                                               @RequestParam("rows") int rows) {
        PageWraper<Custom> pageWraper = new PageWraper<>();
        List<Custom> customList = planService.showAllCustomsByIndexs(page, rows);
        int customAmount = planService.countAllCustoms();
        pageWraper.setRows(customList);
        pageWraper.setTotal(customAmount);
        return pageWraper;

    }

    @RequestMapping("custom/search_custom_by_customName")
    @ResponseBody
    public PageWraper<Custom> searchCustomByCustomName(Custom custom,
                                                   @RequestParam("page") int page,
                                                    @RequestParam("rows") int rows) {
        PageWraper<Custom> pageWraper = new PageWraper<>();
        List<Custom> customList = planService.selectCustomOnCondition(custom, page, rows);
        int customAmount = planService.countAllCustoms();
        pageWraper.setRows(customList);
        pageWraper.setTotal(customAmount);
        return pageWraper;

    }

    @RequestMapping("custom/search_custom_by_customId")
    @ResponseBody
    public PageWraper<Custom> searchCustomByCustomId(Custom custom,
                                                 @RequestParam("page") int page,
                                                @RequestParam("rows") int rows) {
        PageWraper<Custom> pageWraper = new PageWraper<>();
        List<Custom> customList = planService.selectCustomOnCondition(custom, page, rows);
        int customAmount = planService.countAllCustoms();
        pageWraper.setRows(customList);
        pageWraper.setTotal(customAmount);
        return pageWraper;

    }


    @RequestMapping("custom/insert")
    @ResponseBody
    public UserMessage addCustom(Custom custom) {
        boolean addCustom = planService.addCustom(custom);
        UserMessage userMessage = new UserMessage();
        if (addCustom){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }


    @RequestMapping(value = "custom/delete_batch",
            method=RequestMethod.POST,
            consumes="application/x-www-form-urlencoded")
    @ResponseBody
    public UserMessage deleteBatchCustom(String[] ids) {
        boolean addCustom = planService.deleteBatchCustoms(ids);
        UserMessage userMessage = new UserMessage();
        if (addCustom){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }


    @RequestMapping("custom/edit")
    @ResponseBody
    public Custom editCustom(String customId){
        return planService.selectCustomByCustomId(customId);
    }



    @RequestMapping("custom/update_all")
    @ResponseBody
    public UserMessage updateCustom(Custom custom) {


        boolean addCustom = planService.editCustom(custom);
        UserMessage userMessage = new UserMessage();
        if (addCustom){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;

    }


    @RequestMapping("custom/get/{customId}")
    @ResponseBody
    public Custom getCustomByCustomId(@PathVariable("customId") String customId){
        return planService.selectCustomByCustomId(customId);
    }



    @ResponseBody
    @RequestMapping("custom/get_data")
    public List<Custom> getCustomData() {
        List<Custom> customList = planService.showCustomList();
        return customList;
    }



/*-------------------------------------------------------- work -------------------------------------------------------*/











    @RequestMapping("work/list")
    @ResponseBody
    public PageWraper<Work> findWorkByPage(@RequestParam("page") int page,
                                                 @RequestParam("rows") int rows) {
        PageWraper<Work> pageWraper = new PageWraper<>();
        List<Work> workList = planService.showAllWorksByIndexs(page, rows);
        int workAmount = planService.countAllWorks();

        pageWraper.setRows(workList);
        pageWraper.setTotal(workAmount);
        return pageWraper;
    }


    @RequestMapping("work/insert")
    @ResponseBody
    public UserMessage addProduct(Work work) {
        boolean addWork = planService.addWork(work);
        UserMessage userMessage = new UserMessage();
        if (addWork){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }



    @RequestMapping(value = "work/delete_batch",
            method=RequestMethod.POST,
            consumes="application/x-www-form-urlencoded")
    @ResponseBody
    public UserMessage deleteBatchWorks(String[] ids) {
        boolean deleteBatchWorks = planService.deleteBatchWorks(ids);
        UserMessage userMessage = new UserMessage();
        if (deleteBatchWorks){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;
    }


    @RequestMapping("work/update_all")
    @ResponseBody
    public UserMessage updateWork(Work work) {


        boolean updateWork = planService.updateWork(work);
        UserMessage userMessage = new UserMessage();
        if (updateWork){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setStatus(500);
            userMessage.setMsg("FALSE");
        }
        return userMessage;

    }


/************************ 以下四个方法可以使用正则表达式优化 **************************** */

    @RequestMapping("work/search_work_by_workId")
    @ResponseBody
    public PageWraper<Work> searchWorkByWorkId(Work work,
                                                          @RequestParam("page") int page,
                                                          @RequestParam("rows") int rows) {
        PageWraper<Work> pageWraper = new PageWraper<>();
        List<Work> workList = planService.selectWorksOnCondition(work, page, rows);
        int worksAmount = planService.countAllWorksOnCondition(work);
        pageWraper.setRows(workList);
        pageWraper.setTotal(worksAmount);
        return pageWraper;

    }

    @RequestMapping("work/search_work_by_workProduct")
    @ResponseBody
    public PageWraper<Work> searchWorkByWorkProduct(Work work,
                                                        @RequestParam("page") int page,
                                                        @RequestParam("rows") int rows) {
        PageWraper<Work> pageWraper = new PageWraper<>();
        List<Work> workList = planService.selectWorksOnCondition(work, page, rows);
        int worksAmount = planService.countAllWorksOnCondition(work);
        pageWraper.setRows(workList);
        pageWraper.setTotal(worksAmount);
        return pageWraper;

    }

    @RequestMapping("work/search_work_by_workDevice")
    @ResponseBody
    public PageWraper<Work> searchWorkByWorkDevice(Work work,
                                                          @RequestParam("page") int page,
                                                          @RequestParam("rows") int rows) {
        PageWraper<Work> pageWraper = new PageWraper<>();
        List<Work> workList = planService.selectWorksOnCondition(work, page, rows);
        int worksAmount = planService.countAllWorksOnCondition(work);
        pageWraper.setRows(workList);
        pageWraper.setTotal(worksAmount);
        return pageWraper;

    }




    @RequestMapping("work/search_work_by_workProcess")
    @ResponseBody
    public PageWraper<Work> searchWorkByWorkProcess(Work work,
                                                       @RequestParam("page") int page,
                                                       @RequestParam("rows") int rows) {
        PageWraper<Work> pageWraper = new PageWraper<>();
        List<Work> workList = planService.selectWorksOnCondition(work, page, rows);
        int worksAmount = planService.countAllWorksOnCondition(work);
        pageWraper.setRows(workList);
        pageWraper.setTotal(worksAmount);
        return pageWraper;

    }


    @ResponseBody
    @RequestMapping("work/get_data")
    public List<Work> getWorkData() {
        List<Work> workList = planService.showWorkList();

        return workList;
    }

    @ResponseBody
    @RequestMapping("work/get/{workId}")
    public Work selectWorkByWorkId(@PathVariable("workId") String workId) {
        return planService.selectWorkByWorkId(workId);
    }























}
