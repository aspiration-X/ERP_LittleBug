package com.littlebug;

import com.littlebug.bean.UnqualifyApply;
import com.littlebug.dao.UnqualifyApplyMapper;
import com.littlebug.service.QualifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.logging.Logger;

/**
 * created by spir
 * Date2019/4/4 Time 17:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class WangTest {

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;
    @Autowired
    QualifyService qualifyService;

    @Test
    public void testSelectPagination(){
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectPagination(10, 0);
        System.out.println("unqualifyApplies = " + unqualifyApplies);
    }

    @Test
    public void searchUnqualifyByUnqualifyId(){
        List<UnqualifyApply> unqualifyApplies = qualifyService.searchUnqualifyByUnqualifyId("0", 1, 10);
    }

    @Test
    public void searchUnqualifyByProductName(){
        List<UnqualifyApply> unqualifyApplies = qualifyService.searchUnqualifyByProductName("椅子", 1, 10);
    }
}


