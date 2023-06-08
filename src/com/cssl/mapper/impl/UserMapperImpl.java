package com.cssl.mapper.impl;

import com.cssl.mapper.UserMapper;
import com.cssl.pojo.Users;
import com.cssl.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class UserMapperImpl implements UserMapper {
    static SqlSession session = MyBatisUtil.createSqlSession();
    static UserMapper UM = session.getMapper(UserMapper.class);
    @Override
    public Users Login(Users users) {
        return UM.Login(users);
    }

    @Override
    public Integer Regist(Users users) {
        Integer row = UM.Regist(users);
        session.commit();
        return row;
    }

    @Override
    public Users IsExit(String name) {
        return UM.IsExit(name);
    }


}
