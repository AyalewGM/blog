package org.cs544.project.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.cs544.project.domain.User;
import org.cs544.project.service.SecurityService;
import org.cs544.project.service.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LoginController {
	 private String serviceUrl= "http://localhost:8080/";
		@Resource
		private RestTemplate restTemplate;
		@Autowired
	    private UserValidator userValidator;
		@InitBinder
	    private void initBinder(WebDataBinder binder) {
	        binder.setValidator(userValidator);
	    }
		@Autowired
	    private SecurityService securityService;
		
//	@RequestMapping(value= "/login", method = RequestMethod.GET)
//	public ModelAndView login(){
//		ModelAndView model = new ModelAndView();
//		model.setViewName("login");
//		return model;
//	}
//	@RequestMapping(value="/registration", method = RequestMethod.GET)
//	public ModelAndView registration(){
//		ModelAndView model = new ModelAndView();
//		User user = new User();
//		model.addObject("user", user);
//		model.setViewName("registration");
//		return model;
//	}
	
//	@PostMapping("/registration")
//	public String addUser(String name, String username, String password){
//		User user = new User(name, username, password);
//		System.out.println(user.getName());
//		restTemplate.postForLocation(serviceUrl+"registration", user);
//		
//		return "redirect:/posts";
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult result, Model model) {
        userValidator.validate(userForm, result);
        if (result.hasErrors()) {
        	model.addAttribute("message", "Invalid username/password");
           return "registration";
        }
        restTemplate.postForLocation(serviceUrl+"registration", userForm);
       // securityService.autologin(userForm.getUsername(), userForm.getPassword());
        return "redirect:/posts";
    
}
	
	@PostMapping("/loginn")
	public String checkUser(String username,String password, HttpServletRequest request,RedirectAttributes attr){
      System.out.println("checking login");
		User user = (User)restTemplate.getForObject(serviceUrl+"login?username="+username+"&password="+password,User.class);
		if(user==null){
			String message = "wrong username/password";
			attr.addFlashAttribute(message);
			return "redirect:/posts";
		}
		else{
			System.out.println("login "+user.getUsername());
			request.getSession().setAttribute("user", user);
			return "redirect:/posts";
		}
		
		
	}
	
	@GetMapping("/login")
	public String loginPage(Model model, String error, String logout){
		  if (error != null)
	            model.addAttribute("error", "Your username and password is invalid.");
		  if (logout != null)
	            model.addAttribute("message", "You have been logged out successfully.");
		return "login";
		
	}
	@GetMapping("/error")
	public String errorPage(){
		return "error";
	}
	
	@GetMapping("/logout")
	public String logoutPage(HttpServletRequest request){
		request.getSession().invalidate();
		return "redirect:/posts";
	}
//	@RequestMapping(value={"/", "/posts"}, method = RequestMethod.GET)
//	public ModelAndView posts(){
//		ModelAndView model = new ModelAndView();
//		model.setViewName("posts");
//		return model;
//	}
}
