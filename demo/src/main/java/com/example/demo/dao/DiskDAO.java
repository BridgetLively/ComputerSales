package com.example.demo.dao;

import com.example.demo.pojo.Disk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin
public interface DiskDAO extends JpaRepository<Disk,Integer> {
    @Query(value = "select * from disk",nativeQuery = true)
    List<Disk>findByDisk();
}
