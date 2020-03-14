package com.example.demo.service;

import com.example.demo.dao.DiskDAO;
import com.example.demo.pojo.Disk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DiskService {
    @Autowired
    DiskDAO diskDAO;
    public List<Disk>List(){
        return diskDAO.findByDisk();
    }
}
