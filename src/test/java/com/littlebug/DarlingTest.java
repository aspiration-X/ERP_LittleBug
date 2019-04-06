package com.littlebug;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.littlebug.bean.*;
import com.littlebug.service.ManufactureService;
import com.littlebug.service.PlanService;
import com.littlebug.service.TaskService;
import com.littlebug.util.PageWraper;
import org.apache.ibatis.annotations.Param;
import org.junit.Assert;
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

    @Autowired
    ManufactureService manufactureService;

    @Autowired
    TaskService taskService;

    @Test
    public void test1() {
        String[] ids = {"000001", "00000111"};
        boolean batchOrders = planService.deleteBatchOrders(ids);
        System.out.println(batchOrders);
    }


    @Test
    public void test2() {
        int offset = 0;
        int limit = 3;
        String customName = "京东";
        List<COrder> orders = planService.selectOrderByCustom(customName, offset, limit);
        System.out.println(orders);
        System.out.println("orderSize : =================================" + orders.size());
    }

    @Test
    public void test3() {
        int offset = 0;
        int limit = 3;
        String productName = "投影机";
        List<COrder> orders = planService.selectOrderByProduct(productName, offset, limit);
        System.out.println(orders);
//        System.out.println(orders.size() + "=========================");
    }

    @Test
    public void test4() {
        int offset = 0;
        int limit = 3;
        String orderName = "000009";
        List<COrder> orders = planService.selectOrderById(orderName, offset, limit);
        System.out.println(orders.size() + "========================================");
        System.out.println(orders);
    }


    @Test
    public void showAllOrders() {

        List<COrder> orders = planService.showALLOrders();
        System.out.println("-------------------------------------------" + orders.size());

    }

    @Test
    public void customTest() {
        int offset = 0;
        int limit = 3;
        List<Custom> customs = planService.showAllCustomsByIndexs(offset, limit);
        System.out.println(customs.size() + "--------------------------------------------------");
        System.out.println(customs);
    }


    @Test
    public void pageHelperTest() {

        PageHelper.startPage(1, 3);
        List<Custom> customList = planService.showCustomList();
        PageInfo<Custom> pageInfo = new PageInfo<>(customList);

    }


    @Test
    public void customTest2() {

        int page = 1;
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
    public void addCustomTest() {

        Custom custom = new Custom();
        custom.setCustomId("1111");
        custom.setEmail("11111@qq.com");
        boolean addCustom = planService.addCustom(custom);
        System.out.println("==============================" + addCustom + "=================================");

    }

    @Test
    public void deleteBatchCustomByIdsTest() {

        Custom custom = new Custom();
        custom.setCustomId("1111");
        String[] ids = {"1111"};
        boolean batchCustoms = planService.deleteBatchCustoms(ids);
        System.out.println("==============================" + batchCustoms + "=================================");

    }


    @Test
    public void updateCustomTest() {


        Custom custom = new Custom();
        custom.setCustomId("1111");
        custom.setNote("kjl;ddddddddddddddddddddd'");
        custom.setOwnerTel("1111111000");
        boolean updateCustom = planService.updateCustom(custom);
        System.out.println("==============================" + updateCustom + "=================================");

    }

    @Test
    public void selectCustomOnIdLikeTest() {
        Custom custom = new Custom();
        custom.setCustomId("1111");
        custom.setNote("kjl;ddddddddddddddddddddd'");
        List<Custom> customs = planService.selectCustomOnCondition(custom, 0, 3);
        System.out.println(custom + "-----------------------------------------------------------------------------");
    }

    @Test
    public void selectCustomOnNameLikeTest() {
        Custom custom = new Custom();
        custom.setCustomName("新浪");
//        custom.setCustomId("1111");
        custom.setNote("kjl;ddddddddddddddddddddd'");
        List<Custom> customs = planService.selectCustomOnCondition(custom, 0, 3);
        System.out.println(custom + "-----------------------------------------------------------------------------");
    }


    @Test
    public void addProductTest() {
        Product product = new Product();
        product.setProductId("22222");
        product.setProductName("product_name");
        product.setImage("inf/ddd.jpg");
        boolean addProduct = planService.addProduct(product);
        Assert.assertTrue(addProduct);

    }

    @Test
    public void deleteProduct() {

        String[] ids = {"11111", "22222"};
        boolean deleteBatchProducts = planService.deleteBatchProducts(ids);
        Assert.assertTrue(deleteBatchProducts);
    }

    @Test
    public void updateProduct() {

        Product product = new Product();
        product.setProductId("22222");
        product.setProductName("ppppname");
        product.setImage("images/ddd.jpg");
        boolean updateProduct = planService.updateProduct(product);
        Assert.assertTrue(updateProduct);

    }

    @Test
    public void selectAllProductsByIndexTest() {

        int offset = 1;
        int limit = 3;
        List<Product> products = planService.showAllProductsByIndexs(offset, limit);
        int countAllCustoms = planService.countAllCustoms();
        System.out.println(products);
        System.out.println("---------------------------------------------------------");
        System.out.println(countAllCustoms);
    }


    @Test
    public void selectAllProductsOnNameLike() {
        int offset = 1;
        int limit = 3;
        Product product = new Product();
        product.setProductName("哈尔冰");
//        List<Product> products = planService.selectProductsOnCondition(product, offset, limit);
        int account = planService.countAllProductsOnCondition(product);

        System.out.println(account + "----------------------------------------------------");
//        System.out.println("-----------------------------------------------------------" + products.size());
//        System.out.println(products);
        System.out.println(account);

    }

    @Test
    public void selectAllProductsOnIdLike() {
        int offset = 1;
        int limit = 3;
        Product product = new Product();
        product.setProductName("哈尔滨");
        List<Product> products = planService.selectProductsOnCondition(product, offset, limit);
        System.out.println(products);


    }

    @Test
    public void showAllProducts() {


        List<Product> products = planService.showAllProductsByIndexs(1, 3);
        System.out.println(products);
    }


    @Test
    public void selectAllWorksByIndexs() {
        int offset = 1;
        int limit = 3;
        List<Work> workList = planService.showAllWorksByIndexs(offset, limit);
        System.out.println(workList);
        System.out.println("--------------------------------------------------" + workList.size());
    }


    @Test
    public void selectAllWorksOnCondition() {
        int offset = 1;
        int limit = 3;
        Work work = new Work();
//        work.setWorkId("004");
//        List<Work> workList = planService.selectWorksOnCondition(work, offset, limit);
//        work.setDeviceId("003");
//        List<Work> workList = planService.selectWorksOnCondition(work, offset, limit);
//        work.setProcessId("03");
//        List<Work> workList = planService.selectWorksOnCondition(work, offset, limit);
        work.setProductId("00004");
        List<Work> workList = planService.selectWorksOnCondition(work, offset, limit);
        System.out.println(workList);


    }

    @Test
    public void countWorksOnCondition() {
        int offset = 1;
        int limit = 3;
        Work work = new Work();
        int works = planService.countAllWorksOnCondition(work);
        System.out.println("-------------------------------------------------" + works);

    }

    @Test
    public void selectManufacturesOnConditionTest() {

        int offset = 1;
        int limit = 3;
        Manufacture manufacture = new Manufacture();
//        manufacture.setManufactureSn("0002");
        manufacture.setOrderId("000003");
        List<Manufacture> manufactures = manufactureService.selectManufacturesOnCondition(manufacture, offset, limit);
        System.out.println(manufacture);


    }


    @Test
    public void workListTest() {

        List<Manufacture> manufactureList = manufactureService.showManufactureList();
        System.out.println("---------------------------------------------------------------------");
        System.out.println(manufactureList);

    }

    @Test
    public void addTask() {
        int offset = 1;
        int limit = 3;

        Task task = new Task();
        task.setTaskId("001");
        boolean b = taskService.addTask(task);
        Assert.assertTrue(b);
    }


    @Test
    public void selectTaskOnCondition() {
        int offset = 1;
        int limit = 3;

        Task task = new Task();
        task.setManufactureSn("0007");
        List<Task> taskList = taskService.selectTasksOnCondition(task, offset, limit);
        System.out.println("----------------------------------" + taskList.size());
    }


    @Test
    public void selectAllTasks() {


        Task task = new Task();
        task.setTaskId("001");
        List<Task> taskList = taskService.showTaskList();
        System.out.println("-------------------------" + taskList.size());

    }


    @Test
    public void updateTask() {


        Task task = new Task();
        task.setTaskId("001");
        task.setTaskQuantity(111);
        boolean b = taskService.updateTask(task);
        Assert.assertTrue(b);

    }

    @Test
    public void deleteTask() {


        Task task = new Task();
        task.setTaskId("001");
        task.setTaskQuantity(111);
        String[] ids = {"001"};
        boolean b = taskService.deleteBatchTasks(ids);
        Assert.assertTrue(b);

    }


}