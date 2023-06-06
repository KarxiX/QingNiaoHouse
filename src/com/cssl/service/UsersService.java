package com.cssl.service;

import com.cssl.pojo.Users;

public interface UsersService {
    Users Login(Users users);
    //登录
    Integer Regist(Users users);
    //注册

}
