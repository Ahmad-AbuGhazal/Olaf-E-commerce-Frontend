package edu.mum.olaf.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.ParameterizableViewController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ahmad on 18/06/2016.
 */
public class ParamController extends ParameterizableViewController{
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse res)

    {
        Map map=new HashMap<>();
        map.put("msg","Welcome");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        map.put("name",auth.getName());
        ModelAndView modelAndView=new ModelAndView(getViewName(),map);
        return modelAndView;
    }
}
