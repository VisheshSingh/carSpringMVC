package com.vishesh.springmvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	// create a controller method for processing login
	@RequestMapping("/processLogin")
	public String processLogin(@RequestParam("username") String username, @RequestParam("pwd") String password) {

		LoginDAO LD = new LoginDAO();

		if (LD.checkCredentials(username, password)) {
			return "welcome";
		}
		return "home";
	}

	// create a controller method for processing registration
	@RequestMapping("/processRegister")
	public String processRegister(@RequestParam("username") String username, @RequestParam("pwd") String password) {

		LoginDAO LD = new LoginDAO();
		LD.addUserDetails(username, password);
		return "success-register";
	}

	// Create a controller method for handling inventory processing
	@RequestMapping("/processInventory")
	public String processInventory(HttpServletRequest request) {

		HttpSession session = request.getSession();
		LoginDAO LD = new LoginDAO();
		ArrayList<Car> arrcar = LD.getCars();

		session.setAttribute("carlist", arrcar);
		request.setAttribute("carlist", arrcar);
		return "show-cars";
	}
}
