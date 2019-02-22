package com.stackroute.favouriteservice.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favouriteservice.domain.News;
import com.stackroute.favouriteservice.exception.InternalServerError;
import com.stackroute.favouriteservice.exception.NewsAlreadyExistsException;
import com.stackroute.favouriteservice.exception.NewsNotFoundException;
import com.stackroute.favouriteservice.service.NewsService;

import io.jsonwebtoken.Jwts;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/news")
public class NewsController {

	private NewsService newsService;
	private ResponseEntity<?> responseEntity;

	@Autowired
	public NewsController(NewsService newsService) {
		super();
		this.newsService = newsService;
	}

	@GetMapping(value = "/getArticles")
	public ResponseEntity<?> fetchNewsByUserEmail(final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<News> thisNews = null;
		try {
			final String authHeader = request.getHeader("authorization");
			final String token = authHeader.substring(11);
			String userEmail = Jwts.parser().setSigningKey("cognizant").parseClaimsJws(token).getBody().getSubject();
			thisNews = newsService.getNewsByUserEmail(userEmail);
		} catch (NewsNotFoundException e) {
			throw new NewsNotFoundException();
		} catch (Exception e) {
			throw new InternalServerError();
		}
		responseEntity = new ResponseEntity<List<News>>(thisNews, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping
	public ResponseEntity<?> saveNews(@RequestBody final News news, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		try {
			final String authHeader = request.getHeader("authorization");
			final String token = authHeader.substring(11);
			String userEmail = Jwts.parser().setSigningKey("cognizant").parseClaimsJws(token).getBody().getSubject();
			news.setUserEmail(userEmail);
			newsService.saveNews(news);
		} catch (NewsAlreadyExistsException e) {
			throw new NewsAlreadyExistsException();
		} catch (Exception e) {
			throw new InternalServerError();
		}
		responseEntity = new ResponseEntity("{\"message\":\"News Saved Successfully\"}", HttpStatus.OK);
		return responseEntity;
	}
}
