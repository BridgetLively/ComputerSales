package com.example.demo.dao;
import com.example.demo.pojo.Ram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin
public interface RamDAO extends JpaRepository<Ram, Integer>{
    @Query(value = "select * from ram",nativeQuery = true)
    List<Ram>findByRam();
}
