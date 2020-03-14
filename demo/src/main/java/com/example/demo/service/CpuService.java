package com.example.demo.service;

import com.example.demo.dao.CpuDAO;
import com.example.demo.pojo.Cpu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CpuService {
    @Autowired
    CpuDAO cpuDAO;
    public List<Cpu>List(){
        return cpuDAO.findByCpu();
    }
}
