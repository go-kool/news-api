package com.stackroute.favouriteservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.favouriteservice.domain.News;


public interface NewsRepository extends JpaRepository<News, Integer> {

	News findByuserEmailAndTitle(String email, String title);
	List<News> findByuserEmail(String email);
	
	}
