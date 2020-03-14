package com.example.demo.service;
import com.example.demo.dao.PowerDAO;
import com.example.demo.pojo.Power;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PowerService {
    @Autowired
    PowerDAO powerDAO;
    public List<Power>List(){
        return powerDAO.findByPower();
    }
}
