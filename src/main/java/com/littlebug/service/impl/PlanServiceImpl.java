package com.littlebug.service.impl;

import com.littlebug.bean.*;
import com.littlebug.dao.*;
import com.littlebug.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Process;
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
    ProcessMapper processMapper;

    @Autowired
    DeviceMapper deviceMapper;

/*----------------------------------------------------- Order处理方法 ----------------------------------------------------------*/
    @Override
    public List<COrder> showAllOrdersByIndexs(int start, int end) {
        return orderMapper.findOrderByIndexs(start,end);
    }

    @Override
    public List<COrder> showALLOrders() {
        return orderMapper.showAllOrders();
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
        int insert = orderMapper.insert(order);
        return insert == 1;
    }







    /*--------------------------------------------------- product ------------------------------------------------------*/


    @Override
    public boolean addProduct(Product product) {
        return productMapper.insert(product) == 1;
    }

    @Override
    public boolean deleteBatchProducts(String[] ids) {
        for (String id:ids) {
            int delete = productMapper.deleteByPrimaryKey(id);
            if (delete != 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateProduct(Product product) {
        return productMapper.updateByPrimaryKey(product) == 1;
    }


    @Override
    public int countAllProductsOnCondition(Product product) {
        return productMapper.countProductOnCondition(product);
    }

    @Override
    public List<Product> showProductList() {
        return productMapper.selectAllProducts();
    }

    @Override
    public Product selectProductByProductId(String productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public List<Product> selectProductsOnCondition(Product product, int page, int rows) {
        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }

        return productMapper.selectProductOnCondition(product, offset, limit);
    }

    @Override
    public List<Product> showAllProductsByIndexs(int page, int rows) {
        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }
        return productMapper.selectProductsByIndexs(offset, limit);
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


    @Override
    public int countAllProducts() {
        return productMapper.countAllProducts();
    }



    /*--------------------------------------------------- custom ------------------------------------------------------*/

    @Override
    public int countAllCustoms() {
        return customMapper.countAllCustoms();
    }

    @Override
    public List<Custom> showCustomList() {


        List<Custom> customsList = customMapper.selectAllCustoms();
        return customsList;
    }

    @Override
    public int countCustomOnCondition(Custom custom, int page, int rows){
        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }


        return customMapper.countCustomOnCondition(custom, offset, limit);
    }

    @Override
    public Custom selectCustomByCustomId(String customId) {
        return customMapper.selectByPrimaryKey(customId);
    }

    @Override
    public List<Custom> showAllCustomsByIndexs(int page, int rows) {
        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }

        List<Custom> customList = customMapper.showAllCustomsByIndexs(offset, limit);
        return customList;
    }

    @Override
    public List<Custom> selectCustomOnCondition(Custom custom, int offset, int rows) {
        return customMapper.selectCustomOnCondition(custom, offset, rows);
    }

    @Override
    public boolean addCustom(Custom custom) {
        int insert = customMapper.insert(custom);
        return insert == 1;
    }

    @Override
    public boolean deleteBatchCustoms(String[] customIds) {
        for (String id:customIds) {
            int delete = customMapper.deleteByPrimaryKey(id);
            if (delete != 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean editCustom(Custom custom) {
        return customMapper.updateByPrimaryKey(custom) == 1;
    }

    @Override
    public boolean updateCustom(Custom custom) {
        return customMapper.updateByPrimaryKey(custom) == 1;
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

    /*--------------------------------------------------- work ------------------------------------------------------*/



    @Override
    public boolean addWork(Work work) {
        int insert = workMapper.insert(work);
        return insert == 1;
    }

    @Override
    public boolean deleteBatchWorks(String[] ids) {
        for (String id : ids
                ) {
            int delete = workMapper.deleteByPrimaryKey(id);
            if (delete != 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateWork(Work work) {
        return workMapper.updateByPrimaryKey(work) == 1;
    }

    @Override
    public int countAllWorks() {
        return workMapper.countAllWorks();
    }

    @Override
    public List<Work> showAllWorksByIndexs(int page, int rows) {

        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }

        List<Work> workList = workMapper.showAllWorksByIndexs(offset, limit);
        for (Work w:workList) {
            w.setProduct(productMapper.selectByPrimaryKey(w.getProductId()));
            w.setDevice(deviceMapper.selectByPrimaryKey(w.getDeviceId()));
            w.setProcess(processMapper.selectByPrimaryKey(w.getProcessId()));
        }
        return workList;
    }

    @Override
    public List<Work> selectWorksOnCondition(Work work, int page, int rows) {
        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }

        return workMapper.selectWorksOnCondition(work, offset, limit);
    }

    @Override
    public int countAllWorksOnCondition(Work work) {
        return workMapper.countAllWorksOnCondition(work);
    }

    @Override
    public Work selectWorkByWorkId(String workId) {
        return workMapper.selectByPrimaryKey(workId);
    }

    public List<Work> showWorkList(){
        List<Work> workList = workMapper.showAllWorks();
        for (Work w:workList
             ) {
            w.setProduct(productMapper.selectByPrimaryKey(w.getProductId()));
            w.setProcess(processMapper.selectByPrimaryKey(w.getProcessId()));
            w.setDevice(deviceMapper.selectByPrimaryKey(w.getDeviceId()));
        }
        return workList;
    }

    @Override
    public COrder selectOrderByOrderId(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }


}
