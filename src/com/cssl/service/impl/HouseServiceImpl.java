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
    public List<House> FindOneHouse(House house) {
        return HM.FindOneHouse(house);
    }

    @Override
    public House FindDetailHouse(Integer id) {
        return HM.FindDetailHouse(id);
    }

    @Override
    public int AddHouse(House house) {
        return HM.AddHouse(house);
    }


}
