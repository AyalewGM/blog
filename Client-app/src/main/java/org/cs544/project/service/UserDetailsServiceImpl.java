 package org.cs544.project.service;

import org.cs544.project.domain.BlogPost;
import org.cs544.project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	private String serviceUrl= "http://localhost:8080/";
	@Resource
	private RestTemplate restTemplate;
	
	@Autowired
    private HttpSession session;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//User user = userRepository.findByUsername(username);
		User user =restTemplate.getForObject(serviceUrl+"loadUser?username="+username, User.class);
		if(user==null){
			throw new UsernameNotFoundException(username +" is not found");
		}
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        session.setAttribute("user", user);
        
         ResponseEntity<BlogPost[]> userPosts = restTemplate.getForEntity(serviceUrl+"editPost?userId="+user.getId(), BlogPost[].class);
         session.setAttribute("userPosts",userPosts.getBody());
            grantedAuthorities.add(new SimpleGrantedAuthority("USER"));
		 return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        
        }
}
