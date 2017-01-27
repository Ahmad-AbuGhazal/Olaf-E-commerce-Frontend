package edu.mum.olaf.controller;

import javax.validation.Valid;

import edu.mum.olaf.credantial.MD5PasswordEncoder;
import edu.mum.olaf.domain.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.olaf.domain.User;
import edu.mum.olaf.service.UserService;

import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {


	@Autowired
	private UserService userService;
    

    final private List<Address> addresses= new ArrayList<>();
	@RequestMapping({ "/signUp" })
	public String Sign(@ModelAttribute("user") User user, Model model) {
		return "signUp";

	}
	@RequestMapping(value = "/saveAddress",method = RequestMethod.POST)
	public void saveAddress(@Valid@ModelAttribute("address") Address address){

	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processMemberInfo(@Valid @ModelAttribute("user") User usterToRegister,
			BindingResult bindingResult,Model model){
		if(bindingResult.hasErrors()){
			return "signUp";
		} 
		
          String password=usterToRegister.getUserCredentials().getPassword();	
          usterToRegister.getUserCredentials().setPassword(MD5PasswordEncoder.encode(password));
          usterToRegister.getUserCredentials().setVerifyPassword(MD5PasswordEncoder.encode(password));  
		  userService.save(usterToRegister);
		  return "redirect:/registrationSuccess";
	}
	
	@RequestMapping(value="/registrationSuccess",method=RequestMethod.GET)
	public String registrationSuccess(){
		return "registrationSuccess";
	}
	
	
	
	@RequestMapping(value="/users",method=RequestMethod.POST)
	@ResponseBody
	public User registerUser(@RequestBody User user){
		return userService.save(user);
	}
	@ResponseBody
	@RequestMapping(value="/secure/users",method=RequestMethod.GET)
	public List<User> findAllUsers(){
		return userService.findAll();
	}
	@ResponseBody
	@RequestMapping(value="/secure/users/user/{username}",method=RequestMethod.GET)
	public User findUserByName(@PathVariable("username") String username){
		return userService.findByUserName(username);
	}
}
