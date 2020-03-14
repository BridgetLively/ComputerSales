package com.example.demo.dao;
import com.example.demo.pojo.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface ComputerDAO extends JpaRepository<Computer,Integer> {

    @Query(value = "select * from v_allcomputers",nativeQuery = true)
    List<Computer>findByBrand();
}
