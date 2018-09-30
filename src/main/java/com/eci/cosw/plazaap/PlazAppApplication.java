package com.eci.cosw.plazaap;

import com.eci.cosw.plazaap.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PlazAppApplication {


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
}
