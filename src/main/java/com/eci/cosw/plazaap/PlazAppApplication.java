package com.eci.cosw.plazaap;

import com.eci.cosw.plazaap.config.JwtFilter;
import com.eci.cosw.plazaap.data.ProductRepository;
import com.eci.cosw.plazaap.data.UserRepository;
import com.eci.cosw.plazaap.model.AppConfiguration;
import com.eci.cosw.plazaap.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class PlazAppApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRep;

	@Autowired
	private ProductRepository prodRep;


	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/api/*" );

		return registrationBean;
	}


	public static void main(String[] args) {
		SpringApplication.run(PlazAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		userRep.deleteAll();

		userRep.save(new User("prueba@mail.com","pass","Pepito","Perez",true));


		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

	}
}
