package com.littlebug.dao;

import com.littlebug.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    int insert(Product record);

    int deleteByPrimaryKey(String productId);

    int insertSelective(Product record);

    int updateByPrimaryKey(Product record);

    int updateByPrimaryKeySelective(Product record);

    Product selectByPrimaryKey(String productId);

    List<Product> selectAllProducts();


    List<Product> selectProductOnCondition(@Param("product") Product product,
                                           @Param("offset") int offset,
                                           @Param("limit") int limit);

    List<Product> selectProductsByIndexs(@Param("offset") int offset,
                                         @Param("limit") int limit);

    int countProductOnCondition(@Param("product") Product product);

    int countAllProducts();

}