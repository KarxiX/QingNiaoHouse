package com.cssl.service.impl;

import com.cssl.mapper.HouseMapper;
import com.cssl.mapper.impl.HouseMapperImpl;
import com.cssl.pojo.House;
import com.cssl.service.HouseService;

import java.util.List;

public class HouseServiceImpl implements HouseService {
    static HouseMapper HM = new HouseMapperImpl();

    @Override
    public List<House> FindAllHouse() {
        return HM.FindAllHouse();
    }

    @Override
    public List<House> FindOneHouse(String street_id,
                                    String type_id,
                                    String price1,
                                    String price2,
                                    String floorage1,
                                    String floorage2
    ) {
        return HM.FindOneHouse(street_id, type_id, price1, price2, floorage1, floorage2);
    }
    //多条件查询房屋信息

    @Override
    public House FindDetailHouse(Integer id) {
        return HM.FindDetailHouse(id);
    }

    @Override
    public int AddHouse(House house) {
        return HM.AddHouse(house);
    }

    @Override
    public int UpdateHouse(House house) {
        return HM.UpdateHouse(house);
    }

    @Override
    public int DeleteHouse(Integer id) {
        return HM.DeleteHouse(id);
    }


}
