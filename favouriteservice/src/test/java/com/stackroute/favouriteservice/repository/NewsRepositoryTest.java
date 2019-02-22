package com.stackroute.favouriteservice.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.favouriteservice.domain.News;

@RunWith(SpringRunner.class)
@DataJpaTest
public class NewsRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private NewsRepository newsRepository;

	@Test
	public void whenfindByuserEmailAndTitle_ReturnNews() {
		News news = new News();
		news.setTitle("Testing");
		news.setDescription("Testing");
		news.setUrl("Testing");
		news.setUrlToImage("Testing");
		news.setUserEmail("Testing@test.com");
		entityManager.persist(news);
		entityManager.flush();
		News found = newsRepository.findByuserEmailAndTitle(news.getUserEmail(), news.getTitle());
		assertEquals(found.getTitle(), news.getTitle());
	}
	
	@Test
	public void whenfindByuserEmailAndTitle_ReturnNull()
	{
		News news = new News();
		news.setTitle("Testing");
		news.setUrl("TestUrl");
		news.setUrlToImage("TestingImageUrl");
		news.setUserEmail("Testing@test.com");
		news.setDescription("TestDescription");
		entityManager.persist(news);
		entityManager.flush();
		News found = newsRepository.findByuserEmailAndTitle(news.getUserEmail(),"Stackroute");
		assertEquals(found, null);
	}
	
	@Test
	public void findByuserEmail_ReturnListOfUsers()
	{
		News news1=new News();
		news1.setTitle("Testing");
		news1.setUrl("TestUrl");
		news1.setUrlToImage("TestingImageUrl");
		news1.setUserEmail("Testing@test.com");
		news1.setDescription("TestDescription");
		entityManager.persist(news1);
		entityManager.flush();
		List<News> newss=new ArrayList<News>();
		newss.add(news1);
		List<News> found = newsRepository.findByuserEmail(news1.getUserEmail());
		assertEquals(found, newss);
	}
	
	@Test
	public void findByuserEmail_ReturnNull()
	{
		News news1=new News();
		news1.setTitle("Testing");
		news1.setUrl("TestUrl");
		news1.setUrlToImage("TestingImageUrl");
		news1.setUserEmail("Testing@test.com");
		news1.setDescription("TestDescription");
		entityManager.persist(news1);
		entityManager.flush();
		List<News> newss=new ArrayList<News>();
		List<News> found = newsRepository.findByuserEmail("gokul@gmail.com");
		assertEquals(found.size(),newss.size());
	}
}
