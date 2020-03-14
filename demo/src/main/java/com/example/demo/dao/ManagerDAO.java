package com.example.demo.dao;
import com.example.demo.pojo.Cpu;
import com.example.demo.pojo.ManagerComputers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin
public interface ManagerDAO extends JpaRepository<ManagerComputers,Integer>{
    @Query(value = "select * from v_managerallcomputer",nativeQuery = true)
    List<ManagerComputers>findByAllComputers();
}
