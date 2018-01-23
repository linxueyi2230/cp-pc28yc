//package com.dandanyc.dao.impl;
//
//import com.dandanyc.dao.UserDao;
//import com.dandanyc.entity.User;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * Created by prothezou on 2017/1/4.
// */
//@Service
//public class UserDaoImpl implements UserDao {
//
//    @Autowired
//    private SqlSessionFactory sessionFactory;
//
//    public int deleteByPrimaryKey(Integer eggsId) {
//        int result = sessionFactory.openSession().delete("user.deleteByPrimaryKey", eggsId);
//        sessionFactory.openSession().commit();
//        return result;
//    }
//
//    public int insert(User record) {
//        int result = sessionFactory.openSession().insert("user.insert",
//                record);
//        sessionFactory.openSession().commit();
//        return result;
//    }
//
//    public int insertSelective(User record) {
//        int result = sessionFactory.openSession().insert("user.insertSelective",
//                record);
//        sessionFactory.openSession().commit();
//        return result;
//    }
//
//    public User selectByPrimaryKey(Integer eggsId) {
//        User user = sessionFactory.openSession().selectOne("user.selectByPrimaryKey", eggsId);
//        return user;
//    }
//
//    public User selectByUserName(String username) {
//        User user = sessionFactory.openSession().selectOne("user.selectByUserName",username);
//        return user;
//    }
//
//    public int updateByPrimaryKeySelective(User record) {
//        int result = sessionFactory.openSession().selectOne("user.updateByPrimaryKeySelective", record);
//        sessionFactory.openSession().commit();
//        return result;
//    }
//
//    public int updateByPrimaryKey(User record) {
//        int result = sessionFactory.openSession().selectOne("user.updateByPrimaryKey", record);
//        sessionFactory.openSession().commit();
//        return result;
//    }
//}
