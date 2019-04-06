package com.littlebug.service;

import com.littlebug.bean.Manufacture;

import java.util.List;

/**
 * @Author Darling
 * @Description
 * @Date Created in 2019/4/6 2:47
 * @Modified By
 */
public interface ManufactureService {
    boolean addManufacture(Manufacture manufacture);

    boolean deleteBatchManufactures(String[] ids);

    boolean updateManufacture(Manufacture manufacture);

    List<Manufacture> selectManufacturesOnCondition(Manufacture manufacture, int page, int rows);

    int countAllManufacturesOnCondition(Manufacture manufacture);

    List<Manufacture> showManufactureList();

    Manufacture selectManufactureByManufactureId(String manufactureId);

    List<Manufacture> showAllManufacturesByIndexs(int page, int rows);

    int countAllManufactures();
}
