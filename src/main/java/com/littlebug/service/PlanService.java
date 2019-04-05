package com.littlebug.service;

import com.littlebug.bean.*;

import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/3 21:25
 * @Modified By
 */
public interface PlanService {


    /*-------------------------------------------------- order ----------------------------------------------------------*/


    boolean addOrder(COrder order);

    boolean deleteBatchOrders(String[] ids);

    void updateOrder(COrder order);

    List<COrder> selectOrderById(String id, int page, int rows);

    List<COrder> selectOrderByProduct(String productName, int page, int rows);

    List<COrder> selectOrderByCustom(String customName, int page, int rows);

    List<COrder> showAllOrdersByIndexs(int start, int end);



    /*--------------------------------------------------- product ------------------------------------------------------*/


    List<Product> showProductList();

    Product selectProductByProductId(String productId);


    /*--------------------------------------------------- custom ------------------------------------------------------*/

    int countAllCustoms();

    int countCustomOnCondition(Custom custom,int page,int rows);

    List<Custom> showCustomList();

    Custom selectCustomByCustomId(String customId);

    List<Custom> showAllCustomsByIndexs(int offset, int limit);

    List<Custom> selectCustomOnCondition(Custom custom, int offset, int rows);

    boolean addCustom(Custom custom);

    boolean deleteBatchCustoms(String[] customIds);

    boolean editCustom(Custom custom);

    boolean updateCustom(Custom custom);


//
//    List<Work> showWorkList(@Param("page") int page, @Param("rows") int rows);
//    List<Task> showTaskList(@Param("page") int page, @Param("rows") int rows);
//    List<Manufacture> showManufactureList(@Param("page") int page, @Param("rows") int rows);
//
//    PageModel findByPage(@Param("page") int page, @Param("rows") int rows);

}
