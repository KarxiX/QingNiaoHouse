package com.cssl.mapper;

import com.cssl.pojo.House;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseMapper {
    List<House> FindAllHouse();
    //查询所有房子
    List<House> FindOneHouse(House house);
    //多条件查询房屋信息
    House FindDetailHouse(Integer id);
    //查询该房子详细信息
    int AddHouse(House house);
    //添加房子
    int UpdateHouse(House house);
    //更新房子信息
    int DeleteHouse(@Param("id")Integer id);
    //删除房子
}
