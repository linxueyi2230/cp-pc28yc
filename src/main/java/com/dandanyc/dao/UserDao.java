package com.dandanyc.dao;


import com.dandanyc.entity.User;

public interface UserDao {

    int deleteByPrimaryKey(Integer eggsId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer eggsId);

    User selectByUserName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
