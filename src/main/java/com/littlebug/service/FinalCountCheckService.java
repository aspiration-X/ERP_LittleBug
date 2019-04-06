package com.littlebug.service;

import com.littlebug.bean.FinalCountCheck;

import java.util.List;

/**
 * created by spir
 * Date2019/4/6 Time 2:27
 */
public interface FinalCountCheckService {
    List<FinalCountCheck> fCountCheckList(int page, int rows);

    boolean fCountCheckInsert(FinalCountCheck finalCountCheck);

    boolean fCountCheckEdit(FinalCountCheck finalCountCheck);

    boolean fCountCheckDeleteBatch(String ids);

    List<FinalCountCheck> searchFCountCheckByFCountCheckId(String searchValue, int page, int rows);

    List<FinalCountCheck> searchFCountCheckByOrderId(String searchValue, int page, int rows);
}
