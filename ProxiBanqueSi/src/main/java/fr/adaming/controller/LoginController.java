package fr.adaming.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	@RequestMapping(value ="/loginGeneral")
	public String pageLogin(){
	
		return "loginPages";
	}
	
	
	@RequestMapping(value ="/logout")
	public String pageLogoutGerant(){
		return "index";
	}
	
	@RequestMapping(value = "/accessRefuse")
	public String pageAccesRefuse(){
		return "accesRefusePage";
	}
	
	@RequestMapping(value = "/home")
	public String pageIndexToGlobal(){
		return "home";
	}
	
}
