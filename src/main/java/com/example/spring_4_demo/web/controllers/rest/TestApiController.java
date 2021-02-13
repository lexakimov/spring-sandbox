package com.example.spring_4_demo.web.controllers.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author akimov
 * created at 25.11.2020 19:08
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class TestApiController {
	
	@GetMapping("/test")
	public Map<String, Object> test() {
		Map<String, Object> response2 = new HashMap<>();
		
		response2.put("value 1", "test");
		response2.put("value 2", 23332);
		response2.put("value 3", new Date());
		response2.put("value 4", LocalDateTime.now());
		
		Map<String, Object> response = new HashMap<>();
		
		response.put("value 1", "test");
		response.put("value 2", 23332);
		response.put("value 3", new Date());
		response.put("value 4", LocalDateTime.now());
		response.put("value 5", response2);
		
		return response;
	}
	
}
