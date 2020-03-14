package com.example.demo.controller;

import com.example.demo.pojo.Graphics;
import com.example.demo.service.GraphicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
public class GraphicsController {
    @Autowired
    GraphicsService graphicsService;

    @CrossOrigin
    @GetMapping("/api/graphics")
    public List<Graphics>list() throws Exception{
        return graphicsService.List();
    }
}

