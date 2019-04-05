package com.littlebug.controller;

import com.littlebug.bean.UnqualifyApply;
import com.littlebug.service.QualifyService;
import com.littlebug.util.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.soap.SOAPBinding;
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



    /**
     * 不合格品管理
     * @return 对应的jsp页面
     */
    @RequestMapping("unqualify/find")
    public String unqualifyFind(){
        return "unqualify_list";
    }

    /**
     *处理分页查询
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
     * 申请人下来菜单没有，可能是jsp页面有问题
     * @return
     */
    @RequestMapping("")
    public String insert(){
            return "unqualify_add";
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
            UserMessage userMessage = new UserMessage();
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
            return userMessage;
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
            UserMessage userMessage = new UserMessage();
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
            return userMessage;
        }
        return null;

    }

    public void suibi(){

    }

}
