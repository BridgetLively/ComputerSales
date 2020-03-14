package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String username) {
        User user = getByName(username);
        return null!=user;
    }

    public User getByName(String username) {
        return userDAO.findByUsername(username);
    }

    public User get(String username, String password){
        return userDAO.getByUsernameAndPassword(username, password);
    }

    public void login(String username)
    {
        userDAO.login("购物中",username);
    }

    public void add(User user) {
        userDAO.save(user);
    }

    public void register(User user)
    {
        userDAO.register(user.getUsername(),user.getPassword(),"注销");
    }

    public User existsuser(String username)
    {
        return userDAO.existsUserByName(username);
    }

    public void logout()
    {
        userDAO.logout();
    }
    public int getuserid()
    {
        return userDAO.userid("购物中");
    }
    public void message(int userid,String comment)
    {
        userDAO.message(userid,comment);
    }
}
