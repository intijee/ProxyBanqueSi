package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

	@RequestMapping("/loginGerant")
	public String pageLoginGerant(){
		return "loginPageGerant";
	}
	
	@RequestMapping("/loginConseiller")
	public String pageLoginConseiller(){
		return "loginPageGerant";
	}
}
