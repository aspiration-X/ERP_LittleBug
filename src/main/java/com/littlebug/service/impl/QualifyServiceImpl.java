package com.littlebug.service.impl;

import com.littlebug.bean.Employee;
import com.littlebug.bean.Product;
import com.littlebug.bean.UnqualifyApply;
import com.littlebug.dao.EmployeeMapper;
import com.littlebug.dao.ProductMapper;
import com.littlebug.dao.UnqualifyApplyMapper;
import com.littlebug.service.QualifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by spir
 * Date2019/4/4 Time 10:38
 */
@Service
public class QualifyServiceImpl implements QualifyService {
    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public List<UnqualifyApply> queryUnqualifyList(int page,int rows) {


        int limit = rows;
        int offset = (page - 1) * rows ;

        List<UnqualifyApply> unqualifyApplyList = unqualifyApplyMapper.selectPagination(limit,offset);
        return unqualifyApplyList;
    }

    @Override
    public boolean insertUnqualifyApplyByUnqualifyApplyId(UnqualifyApply unqualifyApply) {
        return 1 == unqualifyApplyMapper.insertSelective(unqualifyApply);

    }

    @Override
    public boolean updateAll(UnqualifyApply unqualifyApply) {
        return 1 == unqualifyApplyMapper.updateByPrimaryKey(unqualifyApply);

    }

    @Override
    public boolean deleteBatch(String ids) {
        return 1 == unqualifyApplyMapper.deleteByPrimaryKey(String.valueOf(ids));
    }

    @Override
    public List<UnqualifyApply> searchUnqualifyByUnqualifyId(String searchValue, int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        searchValue = "%" + searchValue + "%";
        return unqualifyApplyMapper.searchUnqualifyByUnqualifyId(searchValue, limit, offset);


    }

    @Override
    public List<UnqualifyApply> searchUnqualifyByProductName(String searchValue, int page, int rows) {
        int limit = rows;
        int offset = (page - 1) * rows ;
        searchValue = "%" + searchValue + "%";
        return unqualifyApplyMapper.searchUnqualifyByProductName(searchValue, limit, offset);
    }

    @Override
    public Product getProductByProductId(String productId) {
        return productMapper.selectByPrimaryKey(productId);

    }

    @Override
    public Employee getEmployeeByempId(String empId) {
       return employeeMapper.getEmployeeByEmployeeId(empId);

    }
}
