package com.theweddingsupplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theweddingsupplier.model.Feedback;
import com.theweddingsupplier.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository fbRepo;
	
	public List<Feedback> getAllFeedbacks(){
		return fbRepo.findAll();
	}
	public Feedback saveFeedback(Feedback fb) {
		return fbRepo.save(fb);
	}
	
}
