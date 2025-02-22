package org.jsp.userapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
	@Autowired
	private UserDao dao;

	public ResponseStructure<User> saveUser(User u) {
		u=dao.saveUser(u);
		
		ResponseStructure<User> rs=new ResponseStructure<>();
		rs.setStatus(200);
		rs.setMessage("User Save Successfully");
		rs.setBody(u);
		
		return rs;
	}
	
	public ResponseStructure<List<User>> findAllUsers(){
		List<User> ul=dao.findAllUsers();
		ResponseStructure<List<User>> structure=new ResponseStructure<>();
		
		structure.setStatus(200);
		structure.setMessage("All Users Found Successfully");
		structure.setBody(ul);
		
		return structure;
		
	}
	
	public ResponseStructure<User> findUsersById(int id) {
		Optional<User> optional=dao.findUsersById(id);
		ResponseStructure<User> structure=new ResponseStructure<>();
		if(optional.isPresent()) {
			structure.setStatus(200);
			structure.setMessage("User Found Successfully");
			structure.setBody(optional.get());
		}
		else {
			structure.setStatus(404);
			structure.setMessage("Invalid User id");
			structure.setBody(null);
		}
		return structure;
	}
	
	public ResponseStructure<User> deleteUserById(int id) {
		Optional<User> optional=dao.findUsersById(id);
		ResponseStructure<User> structure=new ResponseStructure<>();
		if(optional.isPresent()) {
			dao.deleteUserById(id);
			structure.setStatus(200);
			structure.setMessage("User delete Successfully");
			structure.setBody(optional.get());
		}
		else {
			structure.setStatus(404);
			structure.setMessage("Invalid User id");
			structure.setBody(null);
		}
		return structure;
	}
	
	public ResponseStructure<User> updatePhone(String email, String password, long phone) {
		Optional<User> optional=dao.findUsersByEmailAndPassword(email,password);
		ResponseStructure<User> structure=new ResponseStructure<>();
		User u=optional.get();
		if(optional.isPresent()) {
			structure.setStatus(200);
			structure.setMessage("User update Successfully");
			structure.setBody(u);
			u.setPhone(8765432190l);
			dao.saveUser(u);
		}
		else {
			structure.setStatus(404);
			structure.setMessage("Invalid User id");
			structure.setBody(null);
		}
		return structure;
	}
}
