package com.stackroute.favouriteservice.service;

import java.util.List;

import com.stackroute.favouriteservice.domain.News;
import com.stackroute.favouriteservice.exception.NewsAlreadyExistsException;
import com.stackroute.favouriteservice.exception.NewsNotFoundException;


public interface NewsService {

	
	/**
	 * @param id
	 * @return
	 * @throws NewsNotFoundException
	 */
	List<News> getNewsByUserEmail(String email) throws NewsNotFoundException;
	
	
	/**
	 * @param news
	 * @return
	 * @throws NewsAlreadyExistsException
	 */
	boolean saveNews(News news) throws NewsAlreadyExistsException;
}
