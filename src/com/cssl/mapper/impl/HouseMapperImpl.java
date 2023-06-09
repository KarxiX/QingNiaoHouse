package com.cssl.mapper.impl;

import com.cssl.mapper.HouseMapper;
import com.cssl.pojo.House;
import com.cssl.util.MyBatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HouseMapperImpl implements HouseMapper {
    static SqlSession session = MyBatisUtil.createSqlSession();

    private static final HouseMapper HM = session.getMapper(HouseMapper.class);

    @Override
    public List<House> FindAllHouse() {
        List<House> list = HM.FindAllHouse();
        //list.forEach(i -> System.out.println(i));
        return list;
    }

    @Override
    public List<House> FindOneHouse(String title,String street_id,
                                    String type_id,
                                    String price1,
                                    String price2,
                                    String floorage1,
                                    String floorage2
    ) {
        List<House> list = HM.FindOneHouse(title,street_id, type_id, price1, price2, floorage1, floorage2);
        return list;
    }

    //多条件查询房屋信息
    @Override
    public House FindDetailHouse(Integer id) {
        return HM.FindDetailHouse(id);
    }

    @Override
    public int AddHouse(House house) {
        int rows = HM.AddHouse(house);
        session.commit();
        return rows;
    }

    @Override
    public int UpdateHouse(House house) {
        int rows = HM.UpdateHouse(house);
        session.commit();
        return rows;
    }

    @Override
    public int DeleteHouse(Integer id) {
        int rows = HM.DeleteHouse(id);
        session.commit();
        return rows;
    }

}
