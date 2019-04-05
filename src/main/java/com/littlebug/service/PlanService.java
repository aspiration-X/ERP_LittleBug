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



    /*--------------------------------------------------- product ------------------------------------------------------*/

    int countAllProducts();

    List<Product> showAllProductsByIndexs(int page, int rows);

    List<Product> showProductList();

    Product selectProductByProductId(String productId);

    List<Product> selectProductsOnCondition(Product product, int page, int rows);

    int countAllProductsOnCondition(Product product);

    boolean addProduct(Product product);

    boolean deleteBatchProducts(String[] productIds);

    boolean updateProduct(Product product);







    /*--------------------------------------------------- work ------------------------------------------------------*/









}
