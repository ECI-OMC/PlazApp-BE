package com.eci.cosw.plazaap.data;

import com.eci.cosw.plazaap.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findById(int id);
    List<Product> findByType(String type);
    List<Product> findByName(String name);
    List<Product> findByPriceLess(int price);
    List<Product> findByMore(int price);
}