package com.MemberRegistration.MemberDetails.Controller;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MemberRegistration.MemberDetails.model.UserDetails;
import com.MemberRegistration.MemberDetails.repository.UserRepository;
import com.MemberRegistration.MemberDetails.service.UserService;

@RestController
public class UserController {
	@Autowired
    private UserService userservice;
	
	
	
	@PostMapping("/registeruser")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity <UserDetails> MemberRegister(@RequestBody UserDetails userdetails) throws Exception
	{
		String tempEmail=userdetails.getEmail();
		if(tempEmail!=null) {
			UserDetails userobj=userservice.fetchUserByEmailId(tempEmail);
			if(userobj!=null) {
		      throw new Exception("user with"+tempEmail+"is already present")	;	
			}
		}
		UserDetails userobj=null;
		userobj=userservice.saveUser(userdetails);
		String msg= "success";
		return new ResponseEntity<>(userobj, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<UserDetails> LoginUser(@RequestBody UserDetails userdetails) throws Exception {
		String tempEmailId = userdetails.getEmail();
		String tempPassword =userdetails.getPassword();
		UserDetails userobj=null;
		if(tempEmailId !=null && tempPassword !=null ) {
			userobj=userservice.fetchUserByEmailIdAndPassword(tempEmailId, tempPassword);
		}
		if(userobj==null) {

			throw new Exception("Bad credentials");
			
		}
		return new ResponseEntity<>(userobj, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	@CrossOrigin(origins="http://localhost:4200")
	public ResponseEntity<UserDetails> UpdateUser(@RequestBody UserDetails userdetails) throws Exception {
	
		String tempEmailId = userdetails.getEmail();
		UserDetails userobj=null;
		if(tempEmailId != null) {
			userobj=userservice.fetchUserByEmailId(tempEmailId);
		}
		if(userobj==null) {
			throw new Exception("user with"+tempEmailId+"is not present");
		}
		if (userobj!=null) {
			userobj=userservice.saveUser(userdetails);
		}
		return new ResponseEntity<>(userobj, HttpStatus.OK);
	}
	

	
}
