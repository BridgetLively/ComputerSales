package com.example.demo.controller;

import com.example.demo.pojo.Disk;
import com.example.demo.service.DiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class DiskController {
    @Autowired
    DiskService diskService;

    @CrossOrigin
    @GetMapping("/api/disk")
    public List<Disk>list() throws Exception{
        return diskService.List();
    }
}
