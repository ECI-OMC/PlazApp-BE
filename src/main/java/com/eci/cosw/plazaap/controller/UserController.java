package com.eci.cosw.plazaap.controller;

import com.eci.cosw.plazaap.model.User;
import com.eci.cosw.plazaap.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping( "api" )
public class UserController
{

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/login", method = RequestMethod.POST )
    public Token login( @RequestBody User login )
        throws ServletException
    {

        String jwtToken = "";

        if ( login.getEmail() == null || login.getPassword() == null )
        {
            throw new ServletException( "Please fill in email and password" );
        }

        String username = login.getEmail();
        String password = login.getPassword();


        if ( login == null )
        {
            throw new ServletException( "User email not found." );
        }

        String pwd = login.getPassword();

        if ( !password.equals( pwd ) )
        {
            throw new ServletException( "Invalid login. Please check your email and password." );
        }

        jwtToken = Jwts.builder().setSubject( username ).claim( "roles", "user" ).setIssuedAt( new Date() ).signWith(
            SignatureAlgorithm.HS256, "secretkey" ).compact();

        return new Token( jwtToken );
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/user", method = RequestMethod.GET )
    public List<User> getUserList(){
        return userService.getUsers();
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping( value = "/user", method = RequestMethod.POST )
    public void addUser(@RequestBody User newUser){
        userService.addUser(newUser);
    }



    public class Token
    {

        String access_token;


        public Token( String access_token )
        {
            this.access_token = access_token;
        }


        public String getAccessToken()
        {
            return access_token;
        }

        public void setAccessToken( String access_token )
        {
            this.access_token = access_token;
        }
    }

}
