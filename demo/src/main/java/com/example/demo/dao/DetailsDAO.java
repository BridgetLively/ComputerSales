package com.example.demo.dao;

import com.example.demo.pojo.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
public interface DetailsDAO extends JpaRepository<Details,Integer>{
//    List<Details>findAllByBrand(String str);
    @Query(value = "select * from computer c where c.id=?1",nativeQuery = true)
    List<Details>findById(int id);
}
