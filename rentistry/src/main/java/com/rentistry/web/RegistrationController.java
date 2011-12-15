package com.rentistry.web;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.rentistry.domain.Account;
import com.rentistry.domain.Authority;
import com.rentistry.domain.Region;
import com.rentistry.domain.RentUser;
import com.rentistry.web.beans.RegistrationBean;

@RequestMapping("/registration/**")
@Controller
public class RegistrationController {
	
	@Autowired
	PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    	modelMap.addAttribute("regBean", new RegistrationBean());
        return "registration/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(ModelMap modelMap, @Valid RegistrationBean regBean, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
    	if(result.hasErrors()){
    		modelMap.addAttribute("errors", result.getAllErrors());
    		modelMap.addAttribute("regBean", regBean);
    		return "registration/index";
    	}
    	
    	//TODO One question, one answer. Fix this.
    	if(!regBean.getRobotAnswer().toLowerCase().equals("five") && !regBean.getRobotAnswer().toLowerCase().equals("5")){
    		modelMap.addAttribute("errors", "You are not the droid we are looking for.");
    		modelMap.addAttribute("regBean", regBean);
    		return "registration/index";
    	}
    	
    	RentUser user = new RentUser();
    	user.setFirstName(regBean.getFirstName());
    	user.setLastName(regBean.getLastName());
    	user.setUserEmail(regBean.getUserEmail());
    	user.setPassword(passwordEncoder.encodePassword(regBean.getPassword(), null));
    	Set<Authority> authorities = new HashSet();
    	authorities.add((Authority.findAuthoritysByNameEquals("ROLE_USER").getSingleResult()));
    	user.setGivenAuthorities(authorities);
    	user.setAccountExpired(false);
    	user.setAccountLocked(false);
    	user.setCredentialsExpired(false);
    	user.setEnabled(true);
    	user.persist();
    	    	
    	Account account = new Account();
    	account.setAboutMe(regBean.getAboutMe());
    	account.setAvatar(regBean.getAvatar());
    	
    	//TODO hardcode fairfax for now.
    	account.setDefaultRegion(Region.findRegion(1L));
    	account.persist();
    	user.setAccount(account);
    	user.merge();
    	
    	
    	return "registration/setupComplete";
    }

    @RequestMapping
    public String index(ModelMap modelMap) {
    	modelMap.addAttribute("regBean", new RegistrationBean());
        return "registration/index";
    }
    
    //To support file uploads
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws ServletException {
            // to actually be able to convert Multipart instance to byte[]
            // we have to register a custom editor
            binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
            // now Spring knows how to handle multipart object and convert them
        }
}
