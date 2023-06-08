package com.cssl.mapper;

import com.cssl.pojo.Users;

public interface UserMapper {
    Users Login(Users users);
    //登录
    Integer Regist(Users users);
    //注册

    Users IsExit(String name);
}
