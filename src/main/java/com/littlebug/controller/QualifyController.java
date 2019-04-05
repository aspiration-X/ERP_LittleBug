package com.littlebug.controller;

import com.littlebug.bean.*;
import com.littlebug.service.FinalMeasuretCheckService;
import com.littlebug.service.QualifyService;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * created by spir
 * Date2019/4/4 Time 9:55
 */
@Controller
public class QualifyController {
    /**
     * 自动注入qualifyService
     */
    @Autowired
    private QualifyService qualifyService;

    @Autowired
    private FinalMeasuretCheckService finalMeasuretCheckService;

    /**
     * 发送成功的信息
     * @return
     */
    public UserMessage sendSuccessUserMessage(){
        UserMessage userMessage = new UserMessage();
        userMessage.setStatus(200);
        userMessage.setMsg("OK");
        return userMessage;
    }

/*------------------------------------------不合格品管理------------------------------------------------------*/
    /**
     * 不合格品管理按钮
     * @return 对应的jsp页面
     */
    @RequestMapping("unqualify/find")
    public String unqualifyFind(){
        return "unqualify_list";
    }

    /**
     *不合格品管理处理分页查询
     * @param
     * @return
     */
    @RequestMapping("unqualify/list")
    @ResponseBody
    public List<UnqualifyApply> unqualifyList(int page,int rows ){

        List<UnqualifyApply> unqualifyApplyList = qualifyService.queryUnqualifyList(page,rows);
        return unqualifyApplyList;
    }



    /**
     * 不合格品管理—》添加-》
     * @return 跳转至unqualify_add.jsp页面
     */
    @RequestMapping("unqualify/add")
    public String add(){
        return"unqualify_add";
    }

    /**
     * 不合格品管理-》新增
     * @return
     */
    @RequestMapping("unqualify/insert")
    @ResponseBody
    public UserMessage insert( UnqualifyApply unqualifyApply){
        boolean b = qualifyService.insertUnqualifyApplyByUnqualifyApplyId(unqualifyApply);
        if(b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    /**
     * 不合格品管理-》编辑
     * @return
     */
    @RequestMapping("unqualify/edit")
    public String edit(){
            return "unqualify_edit";
    }

    /**
     * 不合格品管理-》编辑不合格品-》提交
     * @param unqualifyApply 修改后的不合格产品
     * @return UserMessage对象
     *                  如果更新成功：
     *                          status：200 成功
     *                          Msg ：OK
     *                  如果更新失败：
     *                          null
     *
     */
    @RequestMapping("unqualify/update_all")
    @ResponseBody
    public UserMessage updateAll(@RequestBody UnqualifyApply unqualifyApply){
        boolean b = qualifyService.updateAll(unqualifyApply);
        if(b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    /**
     * 不合格品管理-》删除
     * @param ids unqualifyApply的主键Id
     * @return UserMessage对象
     *                     如果更新成功：
     *                             status：200 成功
     *                             Msg ：OK
     *                     如果更新失败：
     *                             null
     */
    @RequestMapping("unqualify/delete_batch")
    public UserMessage deleteBatch(String ids ){
        boolean b = qualifyService.deleteBatch(ids);
        if(b){
            return sendSuccessUserMessage();
        }
        return null;

    }

    /**
     * 通过不合格品申请编号的片段模糊搜索不合格产品的集合
     * @param searchValue 不合格品申请编号片段
     * @param page 当前页码数
     * @param rows 显示行数
     * @return 查询的不合格的List
     */
    @RequestMapping("unqualify/search_unqualify_by_unqualifyId")
    @ResponseBody
    public List<UnqualifyApply> searchUnqualifyByUnqualifyId(String searchValue ,int page,int rows){
       return qualifyService.searchUnqualifyByUnqualifyId(searchValue,page,rows);
    }

    /**
     * 通过产品名称片段模糊搜索不合格产品的集合
     * @param searchValue 产品名称片段
     * @param page 当前页码数
     * @param rows 显示行数
     * @return 询的不合格的List
     */
    @RequestMapping("unqualify/search_unqualify_by_productName")
    @ResponseBody
    public List<UnqualifyApply> searchUnqualifyByProductName(String searchValue ,int page,int rows){
        return qualifyService.searchUnqualifyByProductName(searchValue,page,rows);
    }

//    /**
//     * 点击产品名称可以查询该产品详情信息
//     * @param productId 产品Id
//     * @return 该产品详情
//     */
//    @RequestMapping("product/get/{productId}")
//    @ResponseBody
//     public Product getProductByProductId(@PathVariable("productId") String productId){
//        return qualifyService.getProductByProductId(productId);
//     }

    /**
     * 点击申请人可以查询该申请人的详细信息
     * @param empId 申请人Id
     * @return 该申请人详情
     */
    @RequestMapping("employee/get/{empId}")
    @ResponseBody
    public Employee getEmployeeByempId(@PathVariable("empId") String empId){
        return qualifyService.getEmployeeByempId(empId);
    }

/*----------------------------------------------成品计量质检-------------------------------------------------*/

    /**
     * 成品计量质检
     * @return
     */
    @RequestMapping("measure/find")
    public String measurementFind(){
        return "measurement_list";
    }

    /**
     *成品计量质检处理分页查询
     * @param
     * @return
     */
    @RequestMapping("measure/list")
    @ResponseBody
    public List<FinalMeasuretCheck> measureList(int page, int rows ){
        return finalMeasuretCheckService.queryProcessCountCheckList(page,rows);

    }



    /**
     * 成品计量质检—》添加-》
     * @return 跳转至unqualify_add.jsp页面
     */
    @RequestMapping("measure/add")
    public String measureAdd(){
        return"measurement_add";
    }

    @RequestMapping("measure/insert")
    public UserMessage measureInsert(){


        return null;
    }

















}
