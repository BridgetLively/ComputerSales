package com.example.demo.service;

import com.example.demo.dao.RamDAO;
import com.example.demo.pojo.Ram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class RamService {
    @Autowired
    RamDAO ramDAO;
    public List<Ram>List(){
        return ramDAO.findByRam();
    }
}
