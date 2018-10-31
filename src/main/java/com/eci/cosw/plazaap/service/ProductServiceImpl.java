package com.eci.cosw.plazaap.service;

import com.eci.cosw.plazaap.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private List<Product> products = new ArrayList<>();
    public List<String> TIPOS;
    public List<String> PRODS;

    @Autowired
    public ProductServiceImpl()
    {
        /**TIPOS.add("Verdura");
        TIPOS.add("Fruta");
        TIPOS.add("Carnes");
        TIPOS.add("Hortalizas");
        TIPOS.add("Granos");
        TIPOS.add("Tuberculos");**/

        //PRODS.add("");
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

    @Override
    public List<String> getTypes() {
        return this.TIPOS;
    }

    @Override
    public List<String> getProds() {
        return this.PRODS;
    }
}
