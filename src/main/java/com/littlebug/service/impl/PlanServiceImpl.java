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
    public void deleteBatchOrders(String[] ids) {
        for (String id:ids) {
            orderMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public void updateOrder(COrder order) {
        int update = orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public COrder selectOrderById(String id) {
        COrder cOrder = orderMapper.selectByPrimaryKey(id);
        return cOrder;
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



    /*--------------------------------------------------- custom ------------------------------------------------------*/

    @Override
    public List<Custom> showCustomList() {
        List<Custom> customsList = customMapper.selectAllCustoms();
        return customsList;
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
