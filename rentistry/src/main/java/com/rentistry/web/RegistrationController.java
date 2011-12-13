package com.rentistry.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rentistry.web.beans.RegistrationBean;

@RequestMapping("/registration/**")
@Controller
public class RegistrationController {

    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    	modelMap.addAttribute("regBean", new RegistrationBean());
        return "registration/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void post(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index(ModelMap modelMap) {
    	modelMap.addAttribute("regBean", new RegistrationBean());
        return "registration/index";
    }
}
