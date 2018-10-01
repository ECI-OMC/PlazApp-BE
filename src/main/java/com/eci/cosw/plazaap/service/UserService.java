package com.eci.cosw.plazaap.service;

import com.eci.cosw.plazaap.model.User;

import java.util.List;


public interface UserService
{
    List<User> getUsers();

    User getUser( Long id );

    void addUser( User user );

    User findUserByEmail( String email );

    User findUserByEmailAndPassword( String email, String password );

    List<User> getProductores();
}