package com.MemberRegistration.MemberDetails.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MemberRegistration.MemberDetails.model.UserDetails;
import com.MemberRegistration.MemberDetails.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails saveUser(UserDetails userdetails) {
		return userRepository.save(userdetails);
	}
	
	public UserDetails fetchUserByEmailId(String email) {
		
		
		return userRepository.findByEmail(email);
		
	}
	
	public UserDetails fetchUserByEmailIdAndPassword(String email,String password) {
		return userRepository.findByEmailAndPassword(email,password);
	}
	 public UserDetails fetchUserByMemberId(String memberId) {
			
			
			return userRepository.findByMemberId(memberId);
			
		}
	
}
