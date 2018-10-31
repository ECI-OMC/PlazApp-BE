package com.eci.cosw.plazaap.data;

import com.eci.cosw.plazaap.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findById(int id);
    User findByEmail(String email);
}