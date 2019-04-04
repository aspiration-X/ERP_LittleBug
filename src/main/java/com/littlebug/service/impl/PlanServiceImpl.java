package com.littlebug.service.impl;

import com.littlebug.bean.*;
import com.littlebug.dao.*;
import com.littlebug.service.PlanService;
import com.littlebug.util.tag.PageModel;
import org.apache.ibatis.annotations.Param;
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

    @Override
    public List<COrder> showAllOrdersByIndexs(int start, int end) {
        return orderMapper.findOrderByIndexs(start,end);
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
