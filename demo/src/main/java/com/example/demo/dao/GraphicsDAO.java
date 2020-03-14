package com.example.demo.dao;

import com.example.demo.pojo.Graphics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin
public interface GraphicsDAO extends JpaRepository<Graphics,Integer>{
    @Query(value = "select * from graphics",nativeQuery = true)
    List<Graphics>findByGraphics();
}
