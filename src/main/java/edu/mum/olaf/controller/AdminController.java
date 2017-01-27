package edu.mum.olaf.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.olaf.domain.Category;

@RestController
@RequestMapping("/userDashBoad")
public class AdminController {
	
	@RequestMapping(value={"createCategory"})
	public @ResponseBody String addCategory(Category category){
		return "Hello";
	}
}
