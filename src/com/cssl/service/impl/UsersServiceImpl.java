package com.cssl.service.impl;

import com.cssl.mapper.UserMapper;
import com.cssl.mapper.impl.UserMapperImpl;
import com.cssl.pojo.Users;
import com.cssl.service.UsersService;

public class UsersServiceImpl implements UsersService {
    static UserMapper UM = new UserMapperImpl();
    @Override
    public Users Login(Users users) {
        return UM.Login(users);
    }

    @Override
    public Integer Regist(Users users) {
        return UM.Regist(users);
    }

    @Override
    public Users IsExit(String name) {
        return UM.IsExit(name);
    }
}
