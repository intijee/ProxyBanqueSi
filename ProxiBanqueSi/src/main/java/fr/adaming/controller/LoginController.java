package fr.adaming.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		return "home";
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
