package com.eci.cosw.plazaap.model;

import java.util.Calendar;
import java.util.Date;

public class Product {

    private int id;
    private String name;
    private String description;
    private int price;
    private Date date;

    public Product(){

    }

    public Product(String name, String description, int price){
        this.name = name;
        this.description = description;
        this.description = description;
        this.date = Calendar.getInstance().getTime();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
