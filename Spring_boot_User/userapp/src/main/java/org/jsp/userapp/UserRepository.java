package org.jsp.userapp;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByEmailAndPassword(String email, String password);

}
