package edu.mum.olaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.olaf.domain.Category;
import edu.mum.olaf.service.CategoryService;

@Controller
@RequestMapping("userDashBoard/categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public void addCategory(@RequestBody Category category) {
		 categoryService.save(category);
	}
	
	@RequestMapping("/")
	public @ResponseBody List<Category>  getCategories() {
		return categoryService.findAll();
	}
	
	@RequestMapping("/categories/{id}")
	public @ResponseBody Category  getCategory(@PathVariable("id") long id) {
		return categoryService.findOne(id);
	}
}
