package com.littlebug;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.littlebug.bean.COrder;
import com.littlebug.bean.Custom;
import com.littlebug.service.PlanService;
import com.littlebug.util.PageWraper;
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

    @Test
    public void customTest(){
        int offset = 0;
        int limit = 3;
        List<Custom> customs = planService.showAllCustomsByIndexs(offset, limit);
        System.out.println(customs.size() + "--------------------------------------------------");
        System.out.println(customs);
    }


    @Test
    public void pageHelperTest(){

        PageHelper.startPage(1, 3);
        List<Custom> customList = planService.showCustomList();
        PageInfo<Custom> pageInfo = new PageInfo<>(customList);

    }


    @Test
    public void customTest2(){

        int page= 1;
        int rows = 10;
        PageWraper<Custom> pageWraper = new PageWraper<>();
        List<Custom> customList = planService.showAllCustomsByIndexs(page, rows);
        int customAmount = planService.countAllCustoms();
        pageWraper.setRows(customList);
        pageWraper.setTotal(customAmount);
        System.out.println("---------------------------------------------------------");
        System.out.println(pageWraper);
    }

    @Test
    public void addCustomTest(){

        Custom custom = new Custom();
        custom.setCustomId("1111");
        custom.setEmail("11111@qq.com");
        boolean addCustom = planService.addCustom(custom);
        System.out.println("==============================" + addCustom + "=================================");

    }

    @Test
    public void deleteBatchCustomByIdsTest(){

        Custom custom = new Custom();
        custom.setCustomId("1111");
        String[] ids = {"1111"};
        boolean batchCustoms = planService.deleteBatchCustoms(ids);
        System.out.println("==============================" + batchCustoms + "=================================");

    }


    @Test
    public void updateCustomTest(){


        Custom custom = new Custom();
        custom.setCustomId("1111");
        custom.setNote("kjl;ddddddddddddddddddddd'");
        custom.setOwnerTel("1111111000");
        boolean updateCustom = planService.updateCustom(custom);
        System.out.println("==============================" + updateCustom + "=================================");

    }

    @Test
    public void selectCustomOnIdLikeTest(){
        Custom custom = new Custom();
        custom.setCustomId("1111");
        custom.setNote("kjl;ddddddddddddddddddddd'");
        List<Custom> customs = planService.selectCustomOnCondition(custom, 0, 3);
        System.out.println(custom+"-----------------------------------------------------------------------------");
    }

    @Test
    public void selectCustomOnNameLikeTest(){
        Custom custom = new Custom();
        custom.setCustomName("新浪");
//        custom.setCustomId("1111");
        custom.setNote("kjl;ddddddddddddddddddddd'");
        List<Custom> customs = planService.selectCustomOnCondition(custom, 0, 3);
        System.out.println(custom+"-----------------------------------------------------------------------------");
    }




}