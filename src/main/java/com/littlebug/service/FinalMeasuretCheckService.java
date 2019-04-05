package com.littlebug.service;

import com.littlebug.bean.FinalMeasuretCheck;
import com.littlebug.bean.ProcessCountCheck;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 0:27
 */
public interface FinalMeasuretCheckService {

     List<FinalMeasuretCheck> queryProcessCountCheckList(int page, int rows) ;

}
