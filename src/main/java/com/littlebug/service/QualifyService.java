package com.littlebug.service;

import com.littlebug.bean.UnqualifyApply;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by spir
 * Date2019/4/4 Time 10:28
 */
@Service
public interface QualifyService {
    /**
     * 查询不合格产品
     * @param page 请求第几页
     * @param rows 该页显示最多显示多少行
     * @return
     */
    public List<UnqualifyApply> queryUnqualifyList(int page, int rows) ;
}