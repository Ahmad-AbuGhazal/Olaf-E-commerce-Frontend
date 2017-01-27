package edu.mum.olaf.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.olaf.domain.Category;
import edu.mum.olaf.domain.Comment;
import edu.mum.olaf.domain.Item;
import edu.mum.olaf.service.CategoryService;
import edu.mum.olaf.service.CommentService;
import edu.mum.olaf.service.ItemService;
import edu.mum.olaf.service.UserService;
@Controller
@RequestMapping("/userDashBoard")
public class userDashBoardController {
	@Autowired
	CategoryService categoryService;
    @Autowired
    UserService userService;
	
	@Autowired
	ItemService itemService;

	@Autowired 
	CommentService commentService;
	
@RequestMapping(value="")
public String welcome(){
	System.out.println("Welcome UserDashBoard");
	return "userDashBoard/welcome";
}










}
