package com.example.demo.controller;

import com.example.demo.pojo.Ram;
import com.example.demo.service.RamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RamController {
    @Autowired
    RamService ramService;

    @CrossOrigin
    @GetMapping("/api/ram")
    public List<Ram>list() throws Exception{
        return ramService.List();
    }
}

