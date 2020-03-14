package com.example.demo.service;

import com.example.demo.dao.DetailsDAO;
import com.example.demo.pojo.Details;
import com.example.demo.pojo.Order1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsService {
    @Autowired
    DetailsDAO detailsDAO;

    public List<Details>List(int id){
        return detailsDAO.findById(id);
    }


}
