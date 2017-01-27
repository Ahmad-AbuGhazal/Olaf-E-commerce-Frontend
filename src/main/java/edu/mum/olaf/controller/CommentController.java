package edu.mum.olaf.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.olaf.domain.Comment;
import edu.mum.olaf.domain.Item;
import edu.mum.olaf.service.CommentService;
import edu.mum.olaf.service.ItemService;
import edu.mum.olaf.service.UserService;

@RestController
@RequestMapping("/userDashBoard/comments")
public class CommentController {
	@Autowired 
	ItemService itemService;
	
	@Autowired
	UserService userService;
	@Autowired
	CommentService commentService;
	@RequestMapping(value="/addcomment",method=RequestMethod.POST)
	public String addcomment(@ModelAttribute("newcomment")@Valid Comment comment,@RequestParam("itemid") long id,BindingResult result,Model model){
		System.out.println("inside front end");
		if(result.hasErrors()) 
		{ 
		
	       model.addAttribute("error",true);
	       List<Comment> comments=commentService.findAllByItemId(id);
	       model.addAttribute("comments", comments);
	   	   return "userDashBoard/getItem";
		}
			System.out.println("No error");
		 Item item = itemService.findOne(id);
		 User user=(User)(Authentication)SecurityContextHolder.getContext().getAuthentication().getPrincipal() ;
	      comment.setUser(userService.findByUserName(user.getUsername()));
	      comment.setItem(item);
	   	 commentService.save(comment);
		return "userDashBoard/items";
		
	}

	
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public @ResponseBody Comment update(@RequestBody Comment comment) {		
		return commentService.update(comment);
	}
	
	
	@RequestMapping(value = "/findAll/{itemId}", method = RequestMethod.GET) 
	public @ResponseBody List<Comment> findAllByItemId(@PathVariable("itemId") Long itemId) {
		return commentService.findAllByItemId(itemId);
	}	
}
