package com.example.demo.service;

import com.example.demo.dao.GraphicsDAO;
import com.example.demo.pojo.Graphics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class GraphicsService {
    @Autowired
    GraphicsDAO graphicsDAO;
    public List<Graphics>List(){
        return graphicsDAO.findByGraphics();
    }
}
