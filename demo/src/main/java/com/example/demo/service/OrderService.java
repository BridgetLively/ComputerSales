package com.example.demo.service;
import com.example.demo.dao.OrderDAO;

import com.example.demo.pojo.*;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Service
public class OrderService {
    @Autowired
    OrderDAO orderDAO;

    int orderid=0;
    //加入购物车
    public void buyIt1(Order1 order1){
        orderDAO.buyIt1(orderDAO.userid("购物中"),order1.getS_id());
    }

    public void buyIt2(Order2 order2){
        orderDAO.buyIt2(order2.getScreen_id(),order2.getRam_id(),order2.getDisk_id(),order2.getCpu_id(),order2.getPower_id(),order2.getGraphics_id());

    }

    public List<Object>checkshopping()
    {
        return orderDAO.checkshopping();
    }

    @Autowired
    private JavaMailSender mailSender;
    @Test
    public void createorder(UserDetails userDetails) throws Exception{


        orderid=orderid+1;
        orderDAO.updateuser(userDetails.getName(),userDetails.getPhone(),userDetails.getEmail(),userDetails.getAddr(),userDetails.getTicket(),userDetails.getCard());
        orderDAO.insertorderstatus(orderid);
        orderDAO.createorder();
        orderDAO.updateorderid(orderid);
        orderDAO.clearshopping();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("582768808@qq.com");
        message.setTo(userDetails.getEmail());
        message.setSubject("订单详情");
        String content="";
        content=content+"Hi, "+orderDAO.name(orderDAO.userid("购物中"))+"!\n\n";
        content=content+"您所购买的商品有：\n\n";
        List<Object>orderstan=orderDAO.standardid();
        for(int i=0;i<orderstan.size();i++)
        {
            content=content+"标准电脑"+ orderstan.get(i) +"：x1\n";
        }
        content=content+"\n";
        List<Integer>orderdiy=orderDAO.diyid();
        for(int i=0;i<orderdiy.size();i++)
        {
            content=content+"组装电脑"+ orderdiy.get(i) +"：x1 ";
            content=content+"(1显卡："+ orderDAO.diyscreen(orderdiy.get(i))+", 内存："+orderDAO.diyram(orderdiy.get(i))+", 硬盘："+orderDAO.diydisk(orderdiy.get(i))+", CPU："+orderDAO.diycpu(orderdiy.get(i))+", 电源："+orderDAO.diypower(orderdiy.get(i))+", 显卡："+orderDAO.diygraphics(orderdiy.get(i))+")\n";
        }
        content=content+"\n感谢您的选购，\n电脑商城\n";
        message.setText(content);
        mailSender.send(message);


    }

    @Autowired
    public List<Object> orderstatus(){
        return orderDAO.checkorderstatus();
    }

    public void clearshopping()
    {
        orderDAO.clearshopping();
    }
}
