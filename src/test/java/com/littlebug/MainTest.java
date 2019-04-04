package com.littlebug;

import com.littlebug.bean.UnqualifyApply;
import com.littlebug.dao.UnqualifyApplyMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * created by spir
 * Date2019/4/4 Time 17:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class MainTest {

    @Autowired
    UnqualifyApplyMapper unqualifyApplyMapper;
    @Test
    public void myTest(){
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectPagination(10, 0);
        System.out.println(unqualifyApplies);
    }

    @Test
    public void testSelectPagination(){
        List<UnqualifyApply> unqualifyApplies = unqualifyApplyMapper.selectPagination(10, 0);
        System.out.println("unqualifyApplies = " + unqualifyApplies);
    }
}
