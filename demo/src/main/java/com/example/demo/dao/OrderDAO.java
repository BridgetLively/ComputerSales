package com.example.demo.dao;

import com.example.demo.pojo.Details;
import com.example.demo.pojo.Diy;
import com.example.demo.pojo.Order;
import com.example.demo.pojo.Order1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
public interface OrderDAO extends JpaRepository<Order1,Integer>{
    @Modifying@Transactional
    @Query(value = "insert into shopping(userid,standard_id) values(?1,?2)",nativeQuery = true)
    int buyIt1(int userid,int s_id);

    @Modifying@Transactional
    @Query(value = "insert into diy(screen_id,ram_id,disk_id,cpu_id,power_id,graphics_id) values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    int buyIt2(int screen_id,int ram_id,int disk_id,int cpu_id,int power_id,int graphics_id);

    @Query(value = "select id from user u where u.user_status=?1",nativeQuery = true)
    int userid(String str);

    @Query(value = "select name from user u where u.id=?1",nativeQuery = true)
    String name(int id);

    @Query(value = "select standard_id from orderlist where standard_id is not null",nativeQuery = true)
    List<Object> standardid();

    @Query(value = "select diy_id from orderlist where diy_id is not null",nativeQuery = true)
    List<Integer> diyid();

    @Query(value = "select screen_id from diy d where d.id=?1",nativeQuery = true)
    int diyscreen(int id);

    @Query(value = "select ram_id from diy d where d.id=?1",nativeQuery = true)
    int diyram(int id);

    @Query(value = "select disk_id from diy d where d.id=?1",nativeQuery = true)
    int diydisk(int id);

    @Query(value = "select cpu_id from diy d where d.id=?1",nativeQuery = true)
    int diycpu(int id);

    @Query(value = "select power_id from diy d where d.id=?1",nativeQuery = true)
    int diypower(int id);

    @Query(value = "select graphics_id from diy d where d.id=?1",nativeQuery = true)
    int diygraphics(int id);


    @Modifying@Transactional
    @Query(value = "update user o set o.name=?1,o.phone=?2,o.email=?3,o.addr=?4,o.ticket=?5,o.card=?6 where user_status='购物中'",nativeQuery = true)
    int updateuser(String name,String phone,String email,String addr,String ticket,String card);

    @Modifying@Transactional
    @Query(value = "insert into orderlist(userid,standard_id,diy_id) select userid,standard_id,diy_id from shopping",nativeQuery = true)
    int createorder();

    @Modifying@Transactional
    @Query(value = "update orderlist o set o.orderid=?1 where orderid is null ",nativeQuery = true)
    int updateorderid(int orderid);

    @Modifying@Transactional
    @Query(value = "insert into orderlist_status (orderid) values (?1)",nativeQuery = true)
    int insertorderstatus(int orderid);

    @Query(value = "select * from orderlist_status",nativeQuery = true)
    List<Object>checkorderstatus();

    @Query(value = "select * from shopping",nativeQuery = true)
    List<Object>checkshopping();

    @Modifying@Transactional
    @Query(value = "delete from shopping",nativeQuery = true)
    int clearshopping();
}
