package org.cs544.project.Repository;

import org.cs544.project.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer>{
	User findUserById(int id);
	User findUserByUsernameAndPassword(String username, String password);
	User findUserByUsername(String username);
	//void saveUser(User user);
}
