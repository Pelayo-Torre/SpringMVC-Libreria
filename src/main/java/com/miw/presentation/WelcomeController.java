package com.miw.presentation;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.miw.model.LoginData;
import com.miw.validators.LoginValidator;

@SessionAttributes({ "loginCounter" })
@Controller
public class WelcomeController {
	
	@Autowired
	private LoginValidator loginValidator;
	
	@Autowired
	private HttpSession session;
	
	/*
	 * Setting / as request mapping url we are setting the default controller for the application.
	 */
	@RequestMapping("/")
	public String welcome()
	{
		System.out.println("Executing Welcome controller");
		return "login";
	}
	@RequestMapping("/private/menu")
	public String index(Principal p, @ModelAttribute("loginCounter") LoginCounter loginCounter) {
		System.out.println("Executing private/menu controller for user "+ p);
		loginCounter.inc();
		return "private/index";
	}
	@RequestMapping("loginError")
	public String loginError(ModelMap model)
	{
		model.addAttribute("error","true");
		model.addAttribute("message", "Validation error");
		return "login";
	}
	
	@RequestMapping("login")
	public String getForm() {
		System.out.println("Preparing the model for Login");
		return "login";
	}	
	
	@RequestMapping("send")
	public String enviar(@Valid @ModelAttribute("loginForm") LoginData data,
			BindingResult result) throws Exception {
		
		loginValidator.validate(data, result);
		if(result.hasErrors()) {
			return "login";
		}
		return "redirect:private/menu";
	}
	
	@RequestMapping("private/logout")
	public String logout(){
		session.setAttribute("shoppingcart", null);
		return "redirect:/login";
	}
	
	
	@RequestMapping("error")
	public String error() {
		return "error";
	}	
	
	@ModelAttribute("loginCounter")
	public LoginCounter getLoginCounter() {
		System.out.println("Initializing loginCounter");
		return new LoginCounter();
	}
	
	@ModelAttribute("loginForm")
	public LoginData getLoginData() {
		return new LoginData();
	}
}
