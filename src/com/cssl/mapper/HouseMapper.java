package com.cssl.mapper;

import com.cssl.pojo.House;

import java.util.List;

public interface HouseMapper {
    List<House> FindAllHouse();
    //查询所有房子
    List<House> FindOneHouse(House house);
    //多条件查询房屋信息
    House FindDetailHouse(Integer id);
    //查询该房子详细信息
    int AddHouse(House house);

    int UpdateHouse(House house);
}
