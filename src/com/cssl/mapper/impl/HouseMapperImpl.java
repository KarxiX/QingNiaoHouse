package com.cssl.mapper.impl;

import com.cssl.mapper.HouseMapper;
import com.cssl.pojo.House;
import com.cssl.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HouseMapperImpl implements HouseMapper {
    static SqlSession session = MyBatisUtil.createSqlSession();

    private static HouseMapper HM = session.getMapper(HouseMapper.class);

    @Override
    public List<House> FindAllHouse() {
        List<House> list = HM.FindAllHouse();
        //list.forEach(i -> System.out.println(i));
        return list;
    }

    @Override
    public List<House> FindOneHouse(House house) {
        List<House> list = HM.FindOneHouse(house);
        return list;
    }

    @Override
    public House FindDetailHouse(Integer id) {
        return HM.FindDetailHouse(id);
    }

}
