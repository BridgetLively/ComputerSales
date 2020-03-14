package com.example.demo.controller;

import com.example.demo.pojo.Cpu;
import com.example.demo.service.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class CpuController {
    @Autowired
    CpuService cpuService;

    @CrossOrigin
    @GetMapping("/api/cpu")
    public List<Cpu>list() throws Exception{
        return cpuService.List();
    }
}
