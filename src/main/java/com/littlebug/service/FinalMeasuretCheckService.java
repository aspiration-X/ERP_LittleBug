package com.littlebug.service;

import com.littlebug.bean.FinalCountCheck;
import com.littlebug.bean.FinalMeasuretCheck;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 0:27
 */
public interface FinalMeasuretCheckService {

     List<FinalMeasuretCheck> queryProcessCountCheckList(int page, int rows) ;

     boolean updateOne(FinalMeasuretCheck finalMeasuretCheck);

     boolean insertMeasureCheck(FinalMeasuretCheck finalMeasuretCheck);

     boolean deleteMeasure(String ids);

     List<FinalMeasuretCheck> searchMeasureByFMeasureCheckId(String searchValue, int page, int rows);

     List<FinalMeasuretCheck> searchFMeasureCheckByOrderId(String searchValue, int page, int rows);


}
