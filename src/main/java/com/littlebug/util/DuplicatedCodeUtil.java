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
            userMessage.setStatus(500);
            userMessage.setMsg("failure");
        }
        return userMessage;
    }
}
