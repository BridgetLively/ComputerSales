package com.example.demo.controller;
import com.example.demo.pojo.*;

import com.example.demo.result.Result;
import com.example.demo.service.ManagerService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @CrossOrigin
    @GetMapping(value = "/api/manager/getallcomputers")
    public  List<ManagerComputers> ComputerList() throws Exception{
        return managerService.ComputersList();
    }

    @CrossOrigin
    @GetMapping(value = "/api/manager/addcomputer")
    public  List<ManagerComputers> AddComputer() throws Exception{
        return managerService.ComputersList();
    }
}
