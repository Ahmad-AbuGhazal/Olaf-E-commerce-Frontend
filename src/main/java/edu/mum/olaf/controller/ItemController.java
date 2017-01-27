package edu.mum.olaf.controller;

import edu.mum.olaf.domain.Category;
import edu.mum.olaf.domain.Comment;
import edu.mum.olaf.domain.Item;
import edu.mum.olaf.service.CategoryService;
import edu.mum.olaf.service.CommentService;
import edu.mum.olaf.service.ItemService;
import edu.mum.olaf.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/userDashBoard")
public class ItemController {
	@Autowired
	ItemService itemService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	CommentService commentService;
	@RequestMapping(value="/addItem",method=RequestMethod.GET)
	public String addItem(@ModelAttribute("item")Item item,Model model){
	List<Category> categories= categoryService.findAll();
	   model.addAttribute("categories",categories);
	  	return "userDashBoard/addItem";
	}
	
	@RequestMapping(value="/addItem",method=RequestMethod.POST)
	public String addNewItem(@ModelAttribute("item")@Valid Item newitem,BindingResult result,Model model){
System.out.println("Welcome to add new Item");
		if(result.hasErrors()) 
		{ 
		
	    List<Category> categories= categoryService.findAll();
	       model.addAttribute("error",true);
		    model.addAttribute("categories",categories);
		   return "userDashBoard/addItem";
		}
		System.out.println("Size:"+newitem.getCategories().size());
	   Authentication auth=SecurityContextHolder.getContext().getAuthentication() ;   
	      final String username=((User) auth.getPrincipal()).getUsername();
	    	newitem.setSeller(userService.findByUserName(username)); 
	    	
	   	  itemService.save(newitem);
	   	  
		  return "redirect:/items";
		
	}
	@RequestMapping(value="/items",method=RequestMethod.GET)
	public String addItem(Model model){
		model.addAttribute("items", itemService.findAll());
		return "userDashBoard/items";
	}
//	@RequestMapping(value="/items",method=RequestMethod.GET)
//		
//		public @ResponseBody List<Item> items(){
//			return itemService.findAll();
//		}
	@RequestMapping(value="/getItem",method=RequestMethod.GET)
	public String getItem(@RequestParam("id") long id,@ModelAttribute("newcomment") Comment comment,Model model){
		Item item=itemService.findOne(id);
		List<Comment> comments=commentService.findAllByItemId(id);
		model.addAttribute("item", item);
		model.addAttribute("comments", comments);
		return "userDashBoard/itemDetail";
	}
		
//		@RequestMapping(value="/items/{id}",method=RequestMethod.GET)
//		public @ResponseBody Item getitem(@PathVariable("id") long id){
//			return itemService.findOne(id);
//		}
		
		@RequestMapping(value="/itemsBySellerId/{id}",method=RequestMethod.GET)
		public @ResponseBody List<Item> getItemsBySellerId(@PathVariable("id") long id){
			return itemService.findAllBySellerId(id);
		}
	
	
	
//@RequestMapping(value = "/getitem",produces = MediaType.APPLICATION_JSON_VALUE)
		@InitBinder
		protected void initBinder(WebDataBinder binder) 
		{
		    binder.registerCustomEditor(List.class, "categories", new CustomCollectionEditor(List.class)
		    {
		        @Override
		        protected Object convertElement(Object element)
		        {
		            Integer id = null;

		            if(element instanceof String && !((String)element).equals("")){
		                try{
		                    id = Integer.parseInt((String) element);
		                }
		                catch (NumberFormatException e) {
		                    e.printStackTrace();
		                }
		            }
		            else if(element instanceof Integer) {
		                id = (Integer) element;
		            }

		            return id != null ? categoryService.findOne(id) : null;
		        }
		    });
		}
    @ControllerAdvice
    private static class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

        public JsonpAdvice() {
            super("callback");
        }

    }
}
