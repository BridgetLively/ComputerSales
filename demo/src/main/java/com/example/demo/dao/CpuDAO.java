package com.example.demo.dao;

import com.example.demo.pojo.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin
public interface CpuDAO extends JpaRepository<Cpu,Integer>{
    @Query(value = "select * from cpu",nativeQuery = true)
    List<Cpu>findByCpu();
}
