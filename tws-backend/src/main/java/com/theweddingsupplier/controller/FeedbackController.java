package com.theweddingsupplier.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theweddingsupplier.model.Feedback;
import com.theweddingsupplier.service.FeedbackService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tws")
@RequiredArgsConstructor
@Slf4j
public class FeedbackController {
	
	private final FeedbackService fbService;
	
	@GetMapping("/feedback")
	public List<Feedback> getAllFeedbacks(){
		log.info("Get all feedbacks received from user");
		return fbService.getAllFeedbacks();
	}
	@PostMapping(path = "/feedback")											//ok
	public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback fb){
		log.info("Save user's feedback to database: {}", fb.getEmail());
		return ResponseEntity.ok(fbService.saveFeedback(fb));
	}
	
}
