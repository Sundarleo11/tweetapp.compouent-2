package com.tweetapp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tweetapp.controller.TweetController;
import com.tweetapp.model.Login;
import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweet;

@SpringBootTest
@AutoConfigureMockMvc
public class TweetControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TweetController tweetController;
	
	@Test
	public void getAllTweets() throws Exception {
		this.mockMvc.perform(get("/api/v1.0/tweets/all")).andDo(print()).andExpect(status().isOk());
	}
	
	
	@Test
	public void getAllTweetsByUser() throws Exception {
		this.mockMvc.perform(get("/api/v1.0/tweets/test@gmail.com")).andDo(print()).andExpect(status().isOk());
	}
	

	@Test
	public void postTweet() throws Exception {
		
		Tweet tweet = new Tweet();
		tweet.setUsername("sundar");
		tweet.setEmail("test@gmail.com");
		String tweets = "hi";
		tweet.setTweets(tweets);
		
		this.mockMvc.perform(post("/api/v1.0/tweets/test@gmail.com/add").content(tweets)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}
	
	/*
	  @Test public void updateTweet() throws Exception {
	  
	  Tweet t = new Tweet(); //tweet.setUsername("sundar");
	  //tweet.setEmail("test@gmail.com"); t. String tweet = "hi"; //
	 // tweet.setTweets(tweets);
	  
	  String tweet ="hello";
	  
	  this.mockMvc.perform(put("/api/v1.0/tweets/sundarrock1999@gmail.com/update/62f68143542d9666e5d89348").content(
	  tweet)
	  .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
	  andDo(print()).andExpect(status().isOk());
	  //.andExpect(jsonPath("$.content").value("Hello, World!")); 
	  }
	 */
	
	/*
	 * @Test public void deleteTweet() throws Exception {
	 * this.mockMvc.perform(delete(
	 * "/api/v1.0/tweets/sundarrock1999@gmail.com/delete/62f68143542d9666e5d89348"))
	 * .andDo(print()).andExpect(status().isOk()); }
	 */
	
	@Test
	public void likeTweet() throws Exception {
		
		
	this.mockMvc.perform(put("/api/v1.0/tweets/abc@gmail.com/like/62f6678d6a3c5906ce7e2f20")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void disLikeTweet() throws Exception {
				
	this.mockMvc.perform(put("/api/v1.0/tweets/abc@gmail.com/dislike/62f6678d6a3c5906ce7e2f20")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk());
	}
	

	/*
	 * @Test public void replyTweet() throws Exception {
	 * 
	 * Reply reply = new Reply(); reply.setUsername("sundar");
	 * reply.setEmail("sundarrock1999@gmail.com"); reply.setReply("Hello test");
	 * 
	 * this.mockMvc.perform(post(
	 * "/api/v1.0/tweets/abc@gmail.com/reply/62f68f2265b25105920b6f41").content(
	 * asJsonString(reply))
	 * .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).
	 * andDo(print()).andExpect(status().isOk()); }
	 * 
	 * public static String asJsonString(final Object obj) { try { return new
	 * ObjectMapper().writeValueAsString(obj); } catch (Exception e) { throw new
	 * RuntimeException(e); } }
	 */
}
