package com.stackroute.favouriteservice;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stackroute.favouriteservice.filter.JwtFilter;

@SpringBootApplication
public class FavouriteServiceApplication {

	@Bean
	public FilterRegistrationBean<Filter> jwtFilter() {
		final FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(FavouriteServiceApplication.class, args);
	}
}
