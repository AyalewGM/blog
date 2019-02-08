package org.cs544.project.Controller;

import org.cs544.project.domain.User;
import org.cs544.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
	 @Autowired
	    private UserService userService;
	  
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public User registration(@RequestBody User user) {
	        userService.saveUser(user);
	        return user;
	    }
	 
	 @GetMapping("/login")
	 public User checkLogin( @RequestParam String username, @RequestParam String password){
		 System.out.println("checking login on the service");
	User user =(User)userService.findUserByUsernameAndPassword(username,password);
		// System.out.println(user.getName());
		 return user;
	 }
	 
	 @GetMapping("/loadUser")
	 public User loadUser(@RequestParam String username){
		 User user =  userService.findUserByUsername(username);
		 return user;
	 }
}
