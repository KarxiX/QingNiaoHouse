package com.cssl.service;

import com.cssl.pojo.House;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HouseService {
    List<House> FindAllHouse();
    //查询所有房子
    List<House> FindOneHouse(String title,
                             String street_id,
                             String type_id,
                             String price1,
                             String price2,
                             String floorage1,
                             String floorage2
    );
    //多条件查询房屋信息
    House FindDetailHouse(Integer id);
    //查询该房子详细信息
    int AddHouse(House house);
    //添加房子
    int UpdateHouse(House house);
    //修改房子信息

    int DeleteHouse(@Param("id")Integer id);
    //删除房子

    Page<House> findAll4Page(int pageIndex, int pageSize, String title, Integer did, Integer sid, Integer tid, Integer price, Integer floorage);
}
