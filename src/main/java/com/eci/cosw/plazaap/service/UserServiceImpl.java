package com.eci.cosw.plazaap.service;

import com.eci.cosw.plazaap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl
    implements UserService
{

    private List<User> users = new ArrayList<>();


    @Autowired
    public UserServiceImpl()
    {
    }

    @PostConstruct
    private void populateSampleData()
    {
        users.add( new User( "test@mail.com", "password", "Andres", "Perez" , true) );
    }


    @Override
    public List<User> getUsers()
    {
        return users;
    }

    @Override
    public User getUser( Long id )
    {
        int num = id.intValue();
        return users.get(num);
    }

    @Override
    public void addUser( User user )
    {
        users.add( user );
    }

    @Override
    public User findUserByEmail( String email )
    {
        for(User u:users){
            if(u.getEmail().equals(email)){
                return u;
            }
        }

        return(null);

    }

    @Override
    public User findUserByEmailAndPassword( String email, String password )
    {
        for(User u:users){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                return u;
            }
        }

        return(null);
    }

    @Override
    public List<User> getProductores() {
        ArrayList<User> productores = new ArrayList<User>();
        for(User u:users){
            if(u.getProductor()){
                productores.add(u);
            }
        }

        return productores;
    }

}
