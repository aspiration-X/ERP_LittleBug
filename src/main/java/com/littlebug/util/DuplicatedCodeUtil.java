package com.littlebug.util;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/4 Time 21:17
 */
public class DuplicatedCodeUtil {

     /**
     * 根据数据库插入、修改等操作的结果返回状态
     * @param flag
     * @return
     */
    public static UserMessage consequenceMessageReturn(boolean flag){
        UserMessage userMessage = new UserMessage();
        if(flag){
            userMessage.setStatus(200);
            userMessage.setMsg("OK");
        }else {
            userMessage.setMsg("由于未知的原因,操作失败,请重试 ^_^");
        }
        return userMessage;
    }
}
