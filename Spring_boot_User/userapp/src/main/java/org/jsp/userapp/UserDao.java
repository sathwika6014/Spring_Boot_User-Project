package org.jsp.userapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	@Autowired
	private UserRepository repo;

	public User saveUser(User u) {
		return repo.save(u);
	}

	public List<User> findAllUsers() {
		return repo.findAll();
	}

	
	public Optional<User> findUsersById(int id) {
		return repo.findById(id);
	}

	public void deleteUserById(int id) {
		repo.deleteById(id);
	}

	public Optional<User> findUsersByEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email,password);
	}

}
