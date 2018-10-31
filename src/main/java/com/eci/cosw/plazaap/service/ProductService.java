package com.eci.cosw.plazaap.service;

import com.eci.cosw.plazaap.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(int id);

    List<Product> getProductByPrice(int price);

    void addProduct(Product prod);

    List<String> getTypes();

    List<String> getProds();
}
