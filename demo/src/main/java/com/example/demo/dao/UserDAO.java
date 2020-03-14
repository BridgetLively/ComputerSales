package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserDAO extends JpaRepository<User,Integer> {
    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);

    @Modifying
    @Transactional
    @Query(value = "insert into user(username,password,user_status) values(?1,?2,?3)",nativeQuery = true)
    int register(String username,String password,String user_status);

    @Query(value = "select * from user u where u.username=?1",nativeQuery = true)
    User existsUserByName(String str);

    @Modifying
    @Transactional
    @Query(value = "update user u set user_status=?1 where u.username=?2",nativeQuery = true)
    int login(String str1,String username);

    @Query(value = "call logout()",nativeQuery = true)
    int logout();


    @Query(value = "select id from user u where u.user_status=?1",nativeQuery = true)
    int userid(String str);

    @Modifying
    @Transactional
    @Query(value = "insert into message(userid,comment) values(?1,?2)",nativeQuery = true)
    int message(int userid,String comment);
}
