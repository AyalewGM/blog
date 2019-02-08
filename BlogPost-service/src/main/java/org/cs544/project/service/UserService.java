package org.cs544.project.service;


import org.cs544.project.Repository.UserRepository;
import org.cs544.project.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
 @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
      return new BCryptPasswordEncoder();
  }
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public User findUserById(int id){
		return userRepository.findUserById(id);
	}
	public User findUserByUsernameAndPassword(String username, String password){
		return userRepository.findUserByUsernameAndPassword(username, password);
	}
	public User findUserByUsername(String username){
		return userRepository.findUserByUsername(username);
	}
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}
