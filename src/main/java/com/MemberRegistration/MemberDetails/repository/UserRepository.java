package com.MemberRegistration.MemberDetails.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.MemberRegistration.MemberDetails.model.UserDetails;

public interface UserRepository extends MongoRepository<UserDetails,String>{

	public UserDetails findByEmail(String email);
	public UserDetails findByEmailAndPassword(String email, String password);
	public UserDetails findByMemberId(String memberId);
}
