package com.littlebug.service;

import com.littlebug.bean.Employee;
import com.littlebug.bean.Product;
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

    /**
     * 新增不合格产品
     * @param unqualifyApply
     * @return
     */
    boolean insertUnqualifyApplyByUnqualifyApplyId(UnqualifyApply unqualifyApply);

    /**
     * 编辑不合格产品
     * @param unqualifyApply 更新后的不合格产品
     * @return true ：更新成功
     *         false：更失败
     *
     */
    boolean updateAll(UnqualifyApply unqualifyApply);

    boolean deleteBatch(String ids);

    /**
     * 通过不合格产品的id中的片段模糊查找不合格产品集合
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    List<UnqualifyApply> searchUnqualifyByUnqualifyId(String searchValue, int page, int rows);

    /**
     * 通过产品名称的片段模糊查找不合格产品集合
     * @param searchValue
     * @param page
     * @param rows
     * @return
     */
    List<UnqualifyApply> searchUnqualifyByProductName(String searchValue, int page, int rows);

    /**
     * 通过产品Id获取该Product
     * @param productId 产品Id
     * @return
     */
    Product getProductByProductId (String productId);

    /**
     * 通过申请人Id可以查询该申请人的详细信息
     * @param empId
     * @return 该申请人对象
     */
    Employee getEmployeeByempId(String empId);
}
