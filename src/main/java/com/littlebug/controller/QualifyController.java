package com.littlebug.controller;

import com.littlebug.bean.*;
import com.littlebug.bean.Process;
import com.littlebug.dao.ProcessMeasureCheckMapper;
import com.littlebug.service.*;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private FinalCountCheckService finalCountCheckService;

    @Autowired
    private ProcessMeasureCheckService processMeasureCheckService;

    @Autowired
    private ProcessService processService;

    @Autowired
    private ProcessCountCheckService processCountCheckService;
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

    /**
     * 成品计量质检-》添加-》提交
     * @return
     */
    @RequestMapping("measure/insert")
    @ResponseBody
    public UserMessage measureInsert(FinalMeasuretCheck finalMeasuretCheck){
        boolean b = finalMeasuretCheckService.insertMeasureCheck(finalMeasuretCheck);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    /**
     * 成品计量质检-》编辑
     * @return
     */
    @RequestMapping("measure/edit")
    public String measureEdit(){
        return "measurement_edit";
    }

    /**
     * 成品计量质检-》编辑-》提交
     * @param finalMeasuretCheck
     * @return
     */
    @RequestMapping("measure/update_all")
    @ResponseBody
    public UserMessage measureUpdate_all(FinalMeasuretCheck finalMeasuretCheck){
        boolean b = finalMeasuretCheckService.updateOne(finalMeasuretCheck);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    /**
     * 品计量质检-》删除
     * @param ids
     * @return
     */
    @RequestMapping("measure/delete_batch")
    @ResponseBody
    public UserMessage measureDeleteBatch(String ids){
        boolean b = finalMeasuretCheckService.deleteMeasure(ids);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    /**
     * 成品计量质检编号查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("measure/search_fMeasureCheck_by_fMeasureCheckId")
    @ResponseBody
    public List<FinalMeasuretCheck> searchMeasureByFMeasureCheckId(String searchValue ,int page, int rows){
        return finalMeasuretCheckService.searchMeasureByFMeasureCheckId(searchValue, page,rows);
    }

    /**
     * 订单编号查询
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("measure/search_fMeasureCheck_by_orderId")
    @ResponseBody
    public List<FinalMeasuretCheck>searchFMeasureCheckByOrderId(String searchValue ,int page, int rows){
        return finalMeasuretCheckService.searchFMeasureCheckByOrderId(searchValue, page,rows);
    }

/*-------------------------------------成品技术质检-------------------------------------------------------------*/

    @RequestMapping("f_count_check/find")
    public  String fCountCheckFind(){
        return "f_count_check_list";
    }

    @RequestMapping("process/get/{processId}")
    @ResponseBody
    public Process getProcessByProcessId(@PathVariable String processId){
        return processService.getProcessByProcessId(processId);
    }

    @RequestMapping("f_count_check/list")
    @ResponseBody
    public List<FinalCountCheck> fCountCheckList(int page, int rows){
       return finalCountCheckService.fCountCheckList(page,rows);
    }

    @RequestMapping("f_count_check/add")
    public String fCountCheckAdd(){
        return "f_count_check_add";
    }

    @RequestMapping("f_count_check/insert")
    @ResponseBody
    public UserMessage fCountCheckInsert(FinalCountCheck finalCountCheck){
        boolean b = finalCountCheckService.fCountCheckInsert(finalCountCheck);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    @RequestMapping("f_count_check/edit")
    public String  fCountCheckEdit123123(){
        return "f_count_check_edit";
    }

    @RequestMapping("f_count_check/update_all")
    @ResponseBody
    public UserMessage fCountCheckUpdateAll(FinalCountCheck finalCountCheck){
        boolean b = finalCountCheckService.fCountCheckEdit(finalCountCheck);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    @RequestMapping("f_count_check/delete_batch")
    @ResponseBody
    public UserMessage fCountCheckDeleteBatch(String ids){
        boolean b = finalCountCheckService.fCountCheckDeleteBatch(ids);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_fCountCheckId")
    @ResponseBody
    public List<FinalCountCheck> searchFCountCheckByFCountCheckId(String searchValue ,int page, int rows){
        return finalCountCheckService.searchFCountCheckByFCountCheckId(searchValue,page,rows);
    }

    @RequestMapping("f_count_check/search_fCountCheck_by_orderId")
    @ResponseBody
    public List<FinalCountCheck> searchFCountCheckByOrderId(String searchValue ,int page, int rows){
        return finalCountCheckService.searchFCountCheckByOrderId(searchValue,page,rows);
    }

/*-------------------------------------------工序计量质检--------------------------------------------------------------*/

    /**
     * 工序编号
     * @return
     */
    @RequestMapping("process/get_data")
    @ResponseBody
    public List<Process> processGetData(){
        return processService.processGetData();
    }

    @RequestMapping("p_measure_check/find")
    public String pMeasure_checkFind(){
        return "p_measure_check_list";
    }


    @RequestMapping("p_measure_check/list")
    @ResponseBody
    public List<ProcessMeasureCheck> pMeasureCheckList(int page, int rows){
        List<ProcessMeasureCheck> processMeasureCheckMappers = processMeasureCheckService.selectPagination(page, rows);
        return processMeasureCheckMappers;
    }


    @RequestMapping("p_measure_check/add")
        public String pMeasureCheckAdd(){
            return "p_measure_check_add";
    }

    @RequestMapping("p_measure_check/insert")
    @ResponseBody
    public UserMessage pMeasurecheckinsert(ProcessMeasureCheck processMeasureCheck){
        boolean b =processMeasureCheckService.pMeasurecheckinsert(processMeasureCheck);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    @RequestMapping("p_measure_check/edit")
    public String pMeasureCheckEdit(){
        return "p_measure_check_edit";
    }

    @RequestMapping("p_measure_check/update_all")
    @ResponseBody
    public UserMessage pMeasureCheckUpdateAll(ProcessMeasureCheck processMeasureCheck){
        boolean b = processMeasureCheckService.pMeasureCheckUpdateAll(processMeasureCheck);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    @RequestMapping("p_measure_check/delete_batch")
    @ResponseBody
    public UserMessage pmeasureCheckDeleteBatch(String ids){
        boolean b = processMeasureCheckService. pmeasureCheckDeleteBatch(ids);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }

    @RequestMapping("p_measure_check/search_pMeasureCheck_by_pMeasureCheckId")
    @ResponseBody
    public List<ProcessMeasureCheck> searchpMeasureCheckByPMeasureCheckId(String searchValue ,int page, int rows){
         return processMeasureCheckService.searchpMeasureCheckByPMeasureCheckId(searchValue,page,rows);
    }


    /*-----------------------------------------------工序计数质检-----------------------------------------------------------------*/


    @RequestMapping("p_count_check/find")
    public String pCountcheckFind(){
        return "p_count_check_list";
    }

    @RequestMapping("p_count_check/list")
    @ResponseBody
    public List<ProcessCountCheck> pCountcheckList(int page, int rows){
        return processCountCheckService.pCountcheckList(page,rows);
    }

    @RequestMapping("p_count_check/add")
    public String pCountCheckAdd(){
        return "p_count_check_add";
    }

/*    @RequestMapping(value = "p_count_check/inser" ,method = RequestMethod.POST)
    @ResponseBody
    public UserMessage pCountCheckInser(ProcessCountCheck processCountCheck){
        boolean b = processCountCheckService.pCountCheckInser(processCountCheck);
        if (b){
            return sendSuccessUserMessage();
        }
        return null;
    }*/

    @RequestMapping("p_count_check/edit")
    public String pCountCheckEdit(){
        return "p_count_check_edit";
    }











}
