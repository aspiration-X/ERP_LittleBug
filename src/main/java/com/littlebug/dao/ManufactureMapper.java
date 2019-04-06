package com.littlebug.dao;

import com.littlebug.bean.Manufacture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManufactureMapper {
    int deleteByPrimaryKey(String manufactureSn);

    int insert(Manufacture record);

    int insertSelective(Manufacture record);

    Manufacture selectByPrimaryKey(String manufactureSn);

    int updateByPrimaryKeySelective(Manufacture record);

    int updateByPrimaryKey(Manufacture record);
    

    List<Manufacture> selectManufacturesOnCondition(@Param("manufacture") Manufacture manufacture,
                                                    @Param("offset") int offset,
                                                    @Param("limit") int limit);

    int countAllManufacturesOnCondition(@Param("manufacture") Manufacture manufacture);

    int countAllManufactures();

    List<Manufacture> showAllManufatures();

    List<Manufacture> showAllManufacturesByIndexs(@Param("offset") int offset,
                                                  @Param("limit") int limit);
}