package com.littlebug.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by spir
 * Date2019/4/5 Time 0:43
 */
@Controller
public class JudgeController {

    @RequestMapping("**/*_judge")
    @ResponseBody
    public String Judge(){
        return "{}";
    }

}
