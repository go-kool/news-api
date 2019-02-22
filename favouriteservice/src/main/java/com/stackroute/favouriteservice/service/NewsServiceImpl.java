package com.stackroute.favouriteservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.favouriteservice.domain.News;
import com.stackroute.favouriteservice.exception.NewsAlreadyExistsException;
import com.stackroute.favouriteservice.exception.NewsNotFoundException;
import com.stackroute.favouriteservice.repository.NewsRepository;


@Service
public class NewsServiceImpl implements NewsService{

	
	private NewsRepository newsRepository;
	
	
	@Autowired
	public NewsServiceImpl(NewsRepository newsRepository) {
		super();
		this.newsRepository = newsRepository;
	}

	@Override
	public List<News> getNewsByUserEmail(String email) throws NewsNotFoundException {
		final List<News> object = newsRepository.findByuserEmail(email);
		if (object==null) {
			throw new NewsNotFoundException();
		}
		return object;
	}

	@Override
	public boolean saveNews(News news) throws NewsAlreadyExistsException {
		final News object = newsRepository.findByuserEmailAndTitle(news.getUserEmail(),news.getTitle());
		if (object!=null) {
			throw new NewsAlreadyExistsException();
		}
		newsRepository.save(news);
		return true;
	}
	
	

}
