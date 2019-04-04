package com.littlebug.controller;

import com.littlebug.bean.UnqualifyApply;
import com.littlebug.service.QualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    /**
     * 匹配url为unqualify/find的jsp页面
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
     * 添加按钮-》显示外框
     * @return
     */
        @RequestMapping("unqualify/add_judge")
        @ResponseBody
    public String judge(){

        return "{}";
    }

    /**
     * 添加-》
     * @return 跳转至unqualify_add.jsp页面
     */
    @RequestMapping("unqualify/add")
    public String add(){
        return"unqualify_add";
    }

    @RequestMapping("")
public String insert(){
        return "unqualify_add";
}


}
