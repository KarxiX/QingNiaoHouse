package com.cssl.service.impl;

import com.cssl.mapper.HouseMapper;
import com.cssl.mapper.impl.HouseMapperImpl;
import com.cssl.pojo.House;
import com.cssl.service.HouseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

public class HouseServiceImpl implements HouseService {
    static HouseMapper HM = new HouseMapperImpl();

    @Override
    public List<House> FindAllHouse() {
        return HM.FindAllHouse();
    }

    @Override
    public List<House> FindOneHouse(String title,
                                    String street_id,
                                    String type_id,
                                    String price1,
                                    String price2,
                                    String floorage1,
                                    String floorage2
    ) {
        return HM.FindOneHouse(title, street_id, type_id, price1, price2, floorage1, floorage2);
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

    @Override
    public Page<House> findAll4Page(int pageIndex, int pageSize, String title, Integer did, Integer sid, Integer tid, Integer price, Integer floorage) {
        // 调用分页插件的分页方法
        Page<House> page = PageHelper.startPage(pageIndex, pageSize, "id desc");
        // 调用dao层查询方法
        List<House> list = HM.FindAllHouse();
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("总页数：" + page.getPages());
        System.out.println("当前页码：" + page.getPageNum());
        System.out.println("每页容量：" + page.getPageSize());
        List<House> result = page.getResult();
        System.out.println("**************************");
        for (House house : result) {
            System.out.println(house);
        }
        System.out.println("***************************");
        System.out.println("page:" + page);

        return page;
    }


}
