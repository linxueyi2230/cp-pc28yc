package com.dandanyc.service.impl;

import com.dandanyc.dao.UserDao;
import com.dandanyc.entity.User;
import com.dandanyc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by prothezou on 2016/12/31.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int insert(User record) {
        return this.userDao.insert(record);
    }

    public int insertSelective(User record) {
        return this.userDao.insertSelective(record);
    }

    public int deleteByPrimaryKey(Integer eggsId) {
        return this.userDao.deleteByPrimaryKey(eggsId);
    }

    public int updateByPrimaryKey(User record) {
        return this.userDao.updateByPrimaryKey(record);
    }

    public int updateByPrimaryKeySelective(User record) {
        return this.userDao.updateByPrimaryKeySelective(record);
    }

    public User selectByPrimaryKey(Integer eggsId) {
        return this.userDao.selectByPrimaryKey(eggsId);
    }

    public User selectByUserName(String username) {
        return this.userDao.selectByUserName(username);
    }
}
