package com.example.demo.controller;

import com.example.demo.pojo.Details;

import com.example.demo.pojo.Order1;
import com.example.demo.service.DetailsService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
public class DetailsController {
    @Autowired
    DetailsService detailsService;

    @CrossOrigin
    @PostMapping(value = "/api/computer/details")
    @RequestMapping(value = "/api/computer/details",method = RequestMethod.POST)
    public List<Details>list(@RequestBody Details details) throws Exception{

        return detailsService.List(details.getId());
    }



}
