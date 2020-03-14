package com.example.demo.controller;

import com.example.demo.pojo.Computer;
import com.example.demo.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    ComputerService computerService;

    @CrossOrigin
    @GetMapping("/api/computer")
    public List<Computer>list() throws Exception{
        return computerService.List();
    }

}
