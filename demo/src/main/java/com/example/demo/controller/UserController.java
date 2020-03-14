package com.example.demo.controller;

import com.example.demo.pojo.Message;
import com.example.demo.pojo.User;
import com.example.demo.result.Result;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin
    @PostMapping(value = "/api/login")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        User user = userService.get(username, requestUser.getPassword());
        if (null == user) {
            return new Result(400);
        } else {
            userService.login(username);
            return new Result(200);
        }
    }

    @CrossOrigin
    @PostMapping("/api/register")
    @RequestMapping(value = "/api/register",method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User requestUser)
    {
        userService.register(requestUser);

        User user=userService.existsuser(requestUser.getUsername());
        if(null==user)
        {
            return new Result(400);
        }else {
            return new Result(200);
        }
    }

    @CrossOrigin
    @PostMapping("/api/logout")
    @RequestMapping(value = "/api/logout",method = RequestMethod.POST)
    public void logout()
    {
        userService.logout();
    }

    @CrossOrigin
    @PostMapping("/api/message")
    @RequestMapping(value = "/api/message",method = RequestMethod.POST)
    public void message(@RequestBody Message mess)
    {
        userService.message(userService.getuserid(),mess.getComment());
    }

}
