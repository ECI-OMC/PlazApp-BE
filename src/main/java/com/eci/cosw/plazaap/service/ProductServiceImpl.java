package com.eci.cosw.plazaap.service;

import com.eci.cosw.plazaap.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private List<Product> products = new ArrayList<>();

    @Autowired
    public ProductServiceImpl()
    {
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        for(Product p:products){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> getProductByPrice(int price) {
        ArrayList<Product> resp = new ArrayList<>();
        for(Product p:products){
            if(p.getPrice() <= price){
                resp.add(p);
            }
        }
        return resp;
    }

    @Override
    public void addProduct(Product prod) {
        products.add(prod);
    }
}
