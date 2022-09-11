package com.tweetapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweetapp.model.Reply;
import com.tweetapp.model.Tweet;
import com.tweetapp.service.TweetService;

@RestController
@RequestMapping("/api/v1.0/tweets")
@CrossOrigin(origins = "http://localhost:3000")
public class TweetController {
	
	
	@Autowired
	TweetService tweetService;
	
	@GetMapping("/all")
	public List<Tweet> getAllTweets() {
		return tweetService.getAllTweets();
	}
	
	@GetMapping("/{email}")
	public List<Tweet> getAllTweetsByUser(@PathVariable String email) {
		
		return tweetService.getAllTweetsByUser(email);
		
	}
	@PostMapping("/{email}/add")
	public String postTweet(@PathVariable String email,@RequestBody String tweets) {
		
		return tweetService.postTweet(email,tweets);
	}
	
	@PutMapping("/{email}/update/{id}")
	public Tweet updateTweet(@PathVariable String email,@PathVariable String id,@RequestBody String tweets) {
		return  tweetService.updateTweet(email, id, tweets);
	}
	
	@DeleteMapping("/{email}/delete/{id}")
	public String deleteTweet(@PathVariable String email,@PathVariable String id) {
		return  tweetService.deleteTweet(email, id);
	}
	
	@PutMapping("/{email}/like/{id}")
	public int likeTweet(@PathVariable String email,@PathVariable String id) {
		return  tweetService.likeTweet(email, id);
	}
	
	@PutMapping("/{email}/dislike/{id}")
	public int disLikeTweet(@PathVariable String email,@PathVariable String id) {
		return  tweetService.disLikeTweet(email, id);
	}
	
	@PostMapping("/{email}/reply/{id}")
	public Tweet replyTweet(@PathVariable String email,@PathVariable String id ,@RequestBody Reply reply) {
		return  tweetService.replyTweet(email, id, reply);
	}

}
