package com.example.demo.service;

import com.example.demo.pojo.Computer;
import com.example.demo.dao.ComputerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComputerService {
    @Autowired
    ComputerDAO computerDAO;
    public List<Computer>List(){
        return computerDAO.findByBrand();
    }
}
