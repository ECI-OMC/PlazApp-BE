package com.eci.cosw.plazaap.controller;


import com.eci.cosw.plazaap.model.Product;
import com.eci.cosw.plazaap.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "api" )
public class ProductController {

    @Autowired
    private ProductService ps;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/product", method = RequestMethod.GET )
    public List<Product> getProductList(){
        return ps.getProducts();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/product", method = RequestMethod.POST )
    public void addProduct(@RequestBody String type, String name, String quantUnity, int quantity, String description, int price){
        Product prod = new Product(type, name, quantUnity, quantity, description, price);
        ps.addProduct(prod);
    }
}
