package com.theweddingsupplier.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theweddingsupplier.model.Feedback;
import com.theweddingsupplier.service.FeedbackService;

import lombok.SneakyThrows;

@RunWith(SpringRunner.class)
@WebMvcTest(FeedbackController.class)
@AutoConfigureMockMvc
public class FeedbackControllerTest {
	
	@MockBean
	FeedbackService fbService;
	
	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@SneakyThrows
	public void it_should_return_created_feedback() {
		Feedback fb = new Feedback(1, "fb", "fb@gmail.com", "0123456", "abcd");
		
		fbService.saveFeedback(fb);
//		when(fbService.saveFeedback( (Feedback) any(Feedback.class) )).thenReturn(fb);
//		
//		mockMvc.perform(post("/api/tws/feedback")
//						.content(mapper.writeValueAsString(fb))
//						.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$.name").value(fb.getName()));
//		
	}
	
	@Test
	@SneakyThrows
	public void it_should_return_all_feedback() {
		this.mockMvc.perform(get("/api/tws/feeback")).andDo(print()).andExpect(status().isOk());
	}
	
	
	
	
	
	
	
	
	
	
}
