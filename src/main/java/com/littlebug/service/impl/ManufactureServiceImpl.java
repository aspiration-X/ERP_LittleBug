package com.littlebug.service.impl;

import com.littlebug.bean.Manufacture;
import com.littlebug.dao.COrderMapper;
import com.littlebug.dao.ManufactureMapper;
import com.littlebug.dao.TechnologyMapper;
import com.littlebug.service.ManufactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/6 2:48
 * @Modified By
 */
@Service
public class ManufactureServiceImpl implements ManufactureService {


    @Autowired
    ManufactureMapper manufactureMapper;

    @Autowired
    TechnologyMapper technologyMapper;

    @Autowired
    COrderMapper orderMapper;


    @Override
    public boolean addManufacture(Manufacture manufacture) {
        return manufactureMapper.insert(manufacture) == 1;
    }

    @Override
    public boolean deleteBatchManufactures(String[] ids) {

        for (String id : ids
        ) {
            int delete = manufactureMapper.deleteByPrimaryKey(id);
            if (delete != 1){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean updateManufacture(Manufacture manufacture) {
        return manufactureMapper.updateByPrimaryKey(manufacture) == 1;
    }

    @Override
    public List<Manufacture> selectManufacturesOnCondition(Manufacture manufacture, int page, int rows) {

        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }

        return manufactureMapper.selectManufacturesOnCondition(manufacture, offset, limit);
    }

    @Override
    public int countAllManufacturesOnCondition(Manufacture manufacture) {
        return manufactureMapper.countAllManufacturesOnCondition(manufacture);


    }

    @Override
    public List<Manufacture> showManufactureList() {
        List<Manufacture> manufactureList = manufactureMapper.showAllManufatures();
        for (Manufacture m:manufactureList
        ) {
            m.setTechnology(technologyMapper.selectByPrimaryKey(m.getTechnologyId()));
            m.setcOrder(orderMapper.selectByPrimaryKey(m.getOrderId()));
        }
        return manufactureList;
    }

    @Override
    public Manufacture selectManufactureByManufactureId(String manufactureId) {
        Manufacture manufacture = manufactureMapper.selectByPrimaryKey(manufactureId);
        manufacture.setcOrder(orderMapper.selectByPrimaryKey(manufacture.getOrderId()));
        manufacture.setTechnology(technologyMapper.selectByPrimaryKey(manufacture.getTechnologyId()));
        return manufacture;
    }

    @Override
    public List<Manufacture> showAllManufacturesByIndexs(int page, int rows) {
        int offset = 0, limit = 0;

        if (page >= 1){
            offset = (page -1) * rows;
        }
        if (rows >= 1){
            limit = offset + rows;
        }
        List<Manufacture> manufactureList = manufactureMapper.showAllManufacturesByIndexs(offset, limit);
        for (Manufacture m:manufactureList
        ) {
            m.setTechnology(technologyMapper.selectByPrimaryKey(m.getTechnologyId()));
            m.setcOrder(orderMapper.selectByPrimaryKey(m.getOrderId()));
        }
        return manufactureList;

    }

    @Override
    public int countAllManufactures() {
        return manufactureMapper.countAllManufactures();
    }
}
