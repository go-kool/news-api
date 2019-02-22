package com.stackroute.favouriteservice.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.favouriteservice.domain.News;
import com.stackroute.favouriteservice.exception.NewsAlreadyExistsException;
import com.stackroute.favouriteservice.exception.NewsNotFoundException;
import com.stackroute.favouriteservice.repository.NewsRepository;

public class NewsServiceTest {

	@Mock
	private transient NewsRepository newsRepo;

	private transient News news;

	@InjectMocks
	private transient NewsServiceImpl newsServiceImpl;

	transient Optional<News> options;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		news = new News(1, "Testing@gmail.com","https://Harry", "title", "description","url");
		options = Optional.of(news);
	}

	@Test
	public void testMockCreation() {
		assertNotNull("JpaRepository creation failed: use @InjectMocks on newsServiceImpl", news);
	}

	@Test
	public void testSaveNewsSuccess() throws NewsAlreadyExistsException {
		when(newsRepo.findByuserEmailAndTitle(news.getUserEmail(),news.getTitle())).thenReturn(null);
		final boolean flag = newsServiceImpl.saveNews(news);
		assertEquals(true , flag);
		verify(newsRepo, times(1)).save(news);
	}

	@Test(expected = NewsAlreadyExistsException.class)
	public void testSaveNews_returnNewsAlreadyExistsException() throws NewsAlreadyExistsException {
		when(newsRepo.findByuserEmailAndTitle(news.getUserEmail(),news.getTitle())).thenReturn(news);
		final boolean flag = newsServiceImpl.saveNews(news);
		verify(newsRepo, times(1)).save(news);
	}
	
	@Test(expected = NewsNotFoundException.class)
	public void getNewsByUserEmail_returnNewsNotFoundException() throws NewsNotFoundException {
		when(newsRepo.findByuserEmail(news.getUserEmail())).thenReturn(null);
		final List<News> flag = newsServiceImpl.getNewsByUserEmail(news.getUserEmail());
		verify(newsRepo, times(1)).save(news);
	}
	
	@Test
	public void getNewsByUserEmail_returnListOfNews() throws NewsNotFoundException {
		final List<News> news1 = new ArrayList<>();
		news1.add(news);
		when(newsRepo.findByuserEmail(news.getUserEmail())).thenReturn(news1);
		final List<News> flag = newsServiceImpl.getNewsByUserEmail(news.getUserEmail());
	}
	
}
