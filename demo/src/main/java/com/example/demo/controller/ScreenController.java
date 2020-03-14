package com.example.demo.controller;

import com.example.demo.pojo.Ram;
import com.example.demo.pojo.Screen;
import com.example.demo.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScreenController {
    @Autowired
    ScreenService screenService;

    @CrossOrigin
    @GetMapping("/api/screen")
    public List<Screen>list() throws Exception{
        return screenService.List();
    }

}