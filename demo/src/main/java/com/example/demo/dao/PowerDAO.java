package com.example.demo.dao;

import com.example.demo.pojo.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin
public interface PowerDAO extends JpaRepository<Power,Integer>{
    @Query(value = "select * from power",nativeQuery = true)
    List<Power>findByPower();
}
