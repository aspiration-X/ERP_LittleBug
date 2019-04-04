package com.littlebug.service;

import com.littlebug.bean.*;
import com.littlebug.util.tag.PageModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/3 21:25
 * @Modified By
 */
public interface PlanService {

    List<COrder> showAllOrdersByIndexs(int start, int end);


//
//    List<Custom> showCustomList(@Param("page") int page, @Param("rows") int rows);
//    List<Product> showProductList(@Param("page") int page, @Param("rows") int rows);
//    List<Work> showWorkList(@Param("page") int page, @Param("rows") int rows);
//    List<Task> showTaskList(@Param("page") int page, @Param("rows") int rows);
//    List<Manufacture> showManufactureList(@Param("page") int page, @Param("rows") int rows);
//
//    PageModel findByPage(@Param("page") int page, @Param("rows") int rows);

}
