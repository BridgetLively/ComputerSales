package com.example.demo.dao;
import com.example.demo.pojo.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface ScreenDAO extends JpaRepository<Screen,Integer> {
    @Query(value = "select * from screen",nativeQuery = true)
    List<Screen>findByScreen();

}
