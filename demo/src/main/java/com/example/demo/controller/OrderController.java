package com.example.demo.controller;

import com.example.demo.pojo.*;

import com.example.demo.result.Result;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @CrossOrigin
    @PostMapping(value = "/api/computer/details/order1")
    @RequestMapping(value = "/api/computer/details/order1",method = RequestMethod.POST)
    public  void list1(@RequestBody Order1 order1) throws Exception{
        orderService.buyIt1(order1);
    }
    @CrossOrigin
    @PostMapping(value = "/api/computer/details/order2")
    @RequestMapping(value = "/api/computer/details/order2",method = RequestMethod.POST)
    public  void list2(@RequestBody Order2 order2) throws Exception{
        orderService.buyIt2(order2);
    }

    @CrossOrigin
    @PostMapping(value = "/api/createorder")
    @RequestMapping(value = "/api/createorder",method = RequestMethod.POST)
    @ResponseBody
    public Result list2(@RequestBody UserDetails userDetails) throws Exception{

        orderService.createorder(userDetails);
        return new Result(400);
    }

    @CrossOrigin
    @GetMapping("/api/checkorderstatus")
    @PostMapping(value = "/api/checkorderstatus")
    public List<Object> checkorderstatus() throws Exception{
        return orderService.orderstatus();
    }

    @CrossOrigin
    @GetMapping("/api/checkshopping")
    @PostMapping(value = "/api/checkshopping")
    public List<Object> checkshopping() throws Exception{
        return orderService.checkshopping();
    }

    @CrossOrigin
    @PostMapping(value = "/api/clearshopping")
    @RequestMapping(value = "/api/clearshopping",method = RequestMethod.POST)
    public void clearshopping() throws Exception{
        orderService.clearshopping();
    }
}
