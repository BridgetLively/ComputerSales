package com.example.demo.controller;

import com.example.demo.pojo.Power;
import com.example.demo.service.PowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class PowerController {
    @Autowired
    PowerService powerService;

    @CrossOrigin
    @GetMapping("/api/power")
    public List<Power>list() throws Exception{
        return powerService.List();
    }
}
