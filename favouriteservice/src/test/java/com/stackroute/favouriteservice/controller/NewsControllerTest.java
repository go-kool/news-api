package com.stackroute.favouriteservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.favouriteservice.domain.News;
import com.stackroute.favouriteservice.service.NewsService;
import org.springframework.http.MediaType;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(NewsController.class)
public class NewsControllerTest {

	@Autowired
	private transient MockMvc mvc;

	@MockBean
	private transient NewsService service;

	private transient News news;

	@InjectMocks
	private NewsController controller;

	static List<News> news1;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		mvc = MockMvcBuilders.standaloneSetup(controller).build();
		news1 = new ArrayList<>();
		news = new News(1, "gokul123@gmail.com","https://Harry", "title", "description","url");

		news1.add(news);
		news = new News(1, "gokul@gmail.com","https://Harry", "title123", "description","url");
		news1.add(news);
	}

	@Test
	public void testSaveNewNews_Success() throws Exception {
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJnb2t1bEBnbWFpbC5jb20iLCJpYXQiOjE1NTA3NDY0ODB9.mtLvTgbZd2DfzGNb9j6dsaIcFVlQLKsjhp_LRioBTnmtebEexBR--Uf5fJut2dYD";
		when(service.saveNews(news)).thenReturn(true);
		mvc.perform(post("/api/v1/news").header("authorization", "StackRoute " + token)
				.contentType(MediaType.APPLICATION_JSON).content(jsonToString(news))).andExpect(status().isOk());
		verify(service, times(1)).saveNews(Mockito.any(News.class));
		verifyNoMoreInteractions(service);
	}

	@Test
	public void testGetNews() throws Exception {
		String token = "eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJnb2t1bEBnbWFpbC5jb20iLCJpYXQiOjE1NTA3NDY0ODB9.mtLvTgbZd2DfzGNb9j6dsaIcFVlQLKsjhp_LRioBTnmtebEexBR--Uf5fJut2dYD";
		when(service.getNewsByUserEmail(news.getUserEmail())).thenReturn(news1);
		mvc.perform(get("/api/v1/news/getArticles").header("authorization", "StackRoute " + token)
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(service, times(1)).getNewsByUserEmail(news.getUserEmail());
		verifyNoMoreInteractions(service);
	}

	private String jsonToString(final Object object) {
		String result;
		try {
			final ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			result = "Json processing error";
		}
		return result;
	}	
}
