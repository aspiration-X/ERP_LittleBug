package com.littlebug;

import com.littlebug.bean.COrder;
import com.littlebug.service.PlanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class DarlingTest {


    @Autowired
    PlanService planService;

    @Test
    public void test1() {
        String[] ids = {"000001", "00000111"};
        boolean batchOrders = planService.deleteBatchOrders(ids);
        System.out.println(batchOrders);
    }


    @Test
    public void test2(){
        int offset = 0;
        int limit = 3;
        String customName = "京东";
        List<COrder> orders = planService.selectOrderByCustom(customName, offset, limit);
        System.out.println(orders);
        System.out.println("orderSize : ================================="+orders.size());
    }

    @Test
    public void test3(){
        int offset = 0;
        int limit = 3;
        String productName = "投影机";
        List<COrder> orders = planService.selectOrderByProduct(productName, offset, limit);
        System.out.println(orders);
//        System.out.println(orders.size() + "=========================");
    }

    @Test
    public void test4(){
        int offset = 0;
        int limit = 3;
        String orderName = "000009";
        List<COrder> orders = planService.selectOrderById(orderName, offset, limit);
        System.out.println(orders.size()+"========================================");
        System.out.println(orders);
    }
}