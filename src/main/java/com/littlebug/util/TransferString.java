package com.littlebug.util;

import java.util.ArrayList;
import java.util.List;

/**
 * created by ZMX
 * Date 2019/4/4 Time 21:17
 */
public class TransferString {
    public static List<String> transferString(String s){
        List<String> ids = new ArrayList<>();
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for(char c :chars){
            if(',' == c){
                ids.add(stringBuffer.toString());
                stringBuffer.delete(0,stringBuffer.length());
                continue;
            }
            String sc = c + "";
            stringBuffer.append(sc);
        }
        ids.add(stringBuffer.toString());
        return ids;
    }
}
