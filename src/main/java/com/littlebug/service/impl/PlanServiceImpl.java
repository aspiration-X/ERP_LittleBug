package com.littlebug.service.impl;

import com.littlebug.bean.*;
import com.littlebug.dao.*;
import com.littlebug.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/3 21:35
 * @Modified By
 */
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    COrderMapper orderMapper;

    @Autowired
    CustomMapper customMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    WorkMapper workMapper;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    ManufactureMapper manufactureMapper;


/*----------------------------------------------------- Order处理方法 ----------------------------------------------------------*/
    @Override
    public List<COrder> showAllOrdersByIndexs(int start, int end) {
        return orderMapper.findOrderByIndexs(start,end);
    }

    @Override
    public boolean deleteBatchOrders(String[] ids) {

        for (String id:ids) {
            int delete = orderMapper.deleteByPrimaryKey(id);
            if (delete != 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public void updateOrder(COrder order) {
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public List<COrder> selectOrderById(String id, int page, int rows) {
        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }
        String likeId = "%" + id + "%";
        List<COrder> orders = orderMapper.selectByIdLike(likeId, offset, limit);
        return orders;
    }


    @Override
    public boolean addOrder(COrder order) {
        return false;
    }

    @Override
    public boolean deleteJudge(String[] ids) {
        boolean isExits = true;
        for (String id:ids) {
            COrder cOrder = orderMapper.selectByPrimaryKey(id);
            if (cOrder == null){
                isExits = false;
                break;
            }
        }
        return isExits;
    }







    /*--------------------------------------------------- product ------------------------------------------------------*/

    @Override
    public List<Product> showProductList() {
       List<Product> productsList = productMapper.selectAllProducts();
        return productsList;
    }

    @Override
    public List<COrder> selectOrderByProduct(String productName, int page, int rows) {

        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }

        List<COrder> orders = orderMapper.selectOrderByProduct(productName, offset, limit);

        return orders;
    }




    /*--------------------------------------------------- custom ------------------------------------------------------*/

    @Override
    public List<Custom> showCustomList() {


        List<Custom> customsList = customMapper.selectAllCustoms();
        return customsList;
    }



    @Override
    public List<COrder> selectOrderByCustom(String customName, int page, int rows) {
        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }
        List<COrder> orders =  orderMapper.selectOrderByCustom(customName, offset, limit);
        return orders;
    }















//
//    @Override
//    public List<Custom> showCustomList(int page, int rows) {
//        return null;
//    }
//
//    @Override
//    public List<Product> showProductList(int page, int rows) {
//        return null;
//    }
//
//    @Override
//    public List<Work> showWorkList(int page, int rows) {
//        return null;
//    }
//
//    @Override
//    public List<Task> showTaskList(int page, int rows) {
//        return null;
//    }
//
//    @Override
//    public List<Manufacture> showManufactureList(int page, int rows) {
//        return null;
//    }
//
//    @Override
//    public PageModel findByPage(@Param("page") int page, @Param("rows") int rows) {
//        PageModel pageModel = new PageModel();
//        return null;
//    }
}
