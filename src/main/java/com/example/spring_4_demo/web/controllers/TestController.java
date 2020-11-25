package com.example.spring_4_demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author akimov
 * created at 25.11.2020 19:08
 */
@Controller
public class TestController {

	@GetMapping("/home")
	public String getHome() {
		return "home_view";
	}

	@GetMapping("/secured")
	public String getSecured() {
		return "secured_view";
	}

}
