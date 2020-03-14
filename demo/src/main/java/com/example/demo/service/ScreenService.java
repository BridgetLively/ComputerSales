package com.example.demo.service;

import com.example.demo.pojo.Screen;
import com.example.demo.dao.ScreenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScreenService {
    @Autowired
    ScreenDAO screenDAO;
    public List<Screen>List(){
        return screenDAO.findByScreen();
    }
}

