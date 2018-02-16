package com.vishesh.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// create a controller method
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
}
