package com.vishesh.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	// create a controller method for home page
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}

	@RequestMapping("/processLogin")
	public String processLogin(@RequestParam("username") String username, @RequestParam("pwd") String password) {

		LoginDAO LD = new LoginDAO();

		if (LD.checkCredentials(username, password)) {
			return "welcome";
		}
		return "home";
	}
}
