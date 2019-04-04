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

    boolean addOrder(COrder order);

    boolean deleteJudge(String[] ids);

    void deleteBatchOrders(String[] ids);

    void updateOrder(COrder order);

    COrder selectOrderById(String id);

    List<COrder> showAllOrdersByIndexs(int start, int end);



    /*--------------------------------------------------- product ------------------------------------------------------*/
    List<Product> showProductList();



    /*--------------------------------------------------- custom ------------------------------------------------------*/

    List<Custom> showCustomList();














//
//    List<Work> showWorkList(@Param("page") int page, @Param("rows") int rows);
//    List<Task> showTaskList(@Param("page") int page, @Param("rows") int rows);
//    List<Manufacture> showManufactureList(@Param("page") int page, @Param("rows") int rows);
//
//    PageModel findByPage(@Param("page") int page, @Param("rows") int rows);

}
