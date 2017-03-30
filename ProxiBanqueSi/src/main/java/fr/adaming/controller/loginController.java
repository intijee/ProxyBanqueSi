package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class loginController {

	@RequestMapping(value = "/loginGerant")
	public String pageLoginGerant(){
		return "loginPages/loginPagesGerant";
	}
	
	@RequestMapping(value ="/loginConseiller")
	public String pageLoginConseiller(){
		return "loginPages/loginPagesConseiller";
	}
}
