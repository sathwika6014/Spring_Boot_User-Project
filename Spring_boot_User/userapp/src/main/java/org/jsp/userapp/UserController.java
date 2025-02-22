package org.jsp.userapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseStructure<User> saveUser(@RequestBody User u) {
		return service.saveUser(u);
	}
	
	@GetMapping
	public ResponseStructure<List<User>> findAllUsers(){
		return service.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseStructure<User> findUsersById(@PathVariable int id){
		return service.findUsersById(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseStructure<User> deleteUserById(@PathVariable int id){
		return service.deleteUserById(id);
	}
	
	@PatchMapping("/phone/{email}/{password}/{phone}")
	public ResponseStructure<User> updatePhone(@PathVariable String email,@PathVariable String password,@PathVariable long phone){
		return service.updatePhone(email,password,phone);
	}

}
