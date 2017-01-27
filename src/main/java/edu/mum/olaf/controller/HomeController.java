package edu.mum.olaf.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.olaf.domain.UserCredentials;


@Controller
public class HomeController {

	@RequestMapping({ "/", "/welcome" })
	public String welcome() {
		System.out.println("welcome to olaf web project");
		return "welcome";
	}
	
	@RequestMapping(value="login")
	public String login(@ModelAttribute("user") UserCredentials user, Model model){
		model.addAttribute("error","");
		return "login";
	}
	
	@RequestMapping(value="redirectToUserDashBoard")
	public String redirectToUserDashBoard(){
		return "redirect:/userDashBoard/";
	}
	
		@RequestMapping(value={"about"})
	public String about(){
		return "about";
	}
		@RequestMapping(value={"error-forbidden"})
		public String errorForbidden(){
			return "error-forbidden";
		}

			@RequestMapping(value={"logout"})
	public String logout(HttpServletRequest req, HttpServletResponse res){
				
				 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				    if (auth != null){    
				        new SecurityContextLogoutHandler().logout(req, res, auth);
				    }
				    return "redirect:/login";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
			}
			@RequestMapping(value={"loginfailed"})
			public String loginFaild(@ModelAttribute("user") UserCredentials user,Model model )
			{
				model.addAttribute("error","invalid user name");
			return "login";	
			}

}
