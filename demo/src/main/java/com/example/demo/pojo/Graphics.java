package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
@Entity
@Table(name = "graphics")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@CrossOrigin
public class Graphics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String graphics_size;
    String graphics_type;
    double price;
    int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGraphics_size() {
        return graphics_size;
    }

    public void setGraphics_size(String graphics_size) {
        this.graphics_size = graphics_size;
    }

    public String getGraphics_type() {
        return graphics_type;
    }

    public void setGraphics_type(String graphics_type) {
        this.graphics_type = graphics_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
