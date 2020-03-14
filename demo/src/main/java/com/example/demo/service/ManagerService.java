package com.example.demo.service;
import com.example.demo.dao.ManagerDAO;
import com.example.demo.pojo.ManagerComputers;
import com.example.demo.pojo.Screen;
import com.example.demo.dao.ScreenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ManagerService {
    @Autowired
    ManagerDAO managerDAO;
    public List<ManagerComputers>ComputersList(){
        return managerDAO.findByAllComputers();
    }
}
