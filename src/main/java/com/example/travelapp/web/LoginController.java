package com.example.travelapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	//Login form controller method
	@GetMapping(value="/login")
    public String login() {	
        return "login";
    }
}
