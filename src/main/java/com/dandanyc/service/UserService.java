package com.dandanyc.service;


import com.dandanyc.entity.User;

/**
 * Created by prothezou on 2016/12/31.
 */

public interface UserService {

    int deleteByPrimaryKey(Integer eggsId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer eggsId);

    User selectByUserName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
