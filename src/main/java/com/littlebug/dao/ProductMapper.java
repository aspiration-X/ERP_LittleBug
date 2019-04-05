package com.littlebug.dao;

import com.littlebug.bean.Product;

import java.util.List;

public interface ProductMapper {
    int insert(Product record);

    int deleteByPrimaryKey(String productId);

    int insertSelective(Product record);

    int updateByPrimaryKey(Product record);

    int updateByPrimaryKeySelective(Product record);

    Product selectByPrimaryKey(String productId);

    List<Product> selectAllProducts();


    List<Product> selectProductOnCondition(Product product, int offset, int limit);

    List<Product> selectProductsByIndexs(int offset, int limit);

    int countProductOnCondition(Product product);

    int countAllProducts();

}