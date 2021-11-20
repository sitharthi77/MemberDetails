package com.MemberRegistration.MemberDetails.Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.MemberRegistration.MemberDetails.AbstractTest;
import com.MemberRegistration.MemberDetails.model.UserDetails;
import com.MemberRegistration.MemberDetails.service.UserService;
import com.github.andrewoma.dexx.collection.ArrayList;
import com.MemberRegistration.MemberDetails.model.Claim;
import com.MemberRegistration.MemberDetails.model.Dependent;

import org.springframework.http.MediaType;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTests extends AbstractTest{
	private MockMvc mockMvc;
	
	
	@InjectMocks
    private UserController controller;
	
	@Mock
    private UserService service;
	
	 @Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	  
	  
	  
	  
	@Test
	   public void MemberRegister() throws Exception {
		   
	      String uri = "/registeruser";
	    
	      UserDetails user = new UserDetails();
	      
	      user.setFirstName("arthi");
	      user.setLastName("karunanidhi");
	      user.setMemberId("R-102");
	      user.setEmail("sithu@gmail.com");
	      user.setPassword("Sweety@10");
	      user.setAddress("teachers colony");
	      user.setContactNumber("7823991008");
	      user.setState("tamilnadu");
	      user.setCountry("india");
	      user.setPan("ENIPS7410BRY");
	      
	      List<Dependent> emptylist=Collections.emptyList();
	      user.setDependents(emptylist);
	      List<Claim> emptylist1=Collections.emptyList();
	      user.setClaims(emptylist1);
	      String inputJson = super.mapToJson(user);
	      
	      
	     MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	       .contentType(MediaType.APPLICATION_JSON_VALUE)
	     .content(inputJson)).andReturn();
	      
	     int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	     
	   }

	  @Test
	   public void UpdateUser() throws Exception {
		  
		  String uri = "/update";
	      UserDetails user = new UserDetails();
	      
	      
	      user.setFirstName("arthi");
	      user.setLastName("karunanidhi");
	      user.setMemberId("R-102");
	      user.setEmail("sithu@gmail.com");
	      user.setPassword("Sweety@10");
	      user.setAddress("teachers colony");
	      user.setContactNumber("7823991008");
	      user.setState("tamilnadu");
	      user.setCountry("india");
	      user.setPan("ENIPS7410BRY");
	      
	      List<Dependent> emptylist=Collections.emptyList();
	      user.setDependents(emptylist);
	      List<Claim> emptylist1=Collections.emptyList();
	      user.setClaims(emptylist1);
	      String inputJson = super.mapToJson(user);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	        .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	      
	   }
	  
	  @Test
	   public void LoginUser() throws Exception {
		  
		   
	      UserDetails user = new UserDetails();
	      
	      
	      user.setEmail("sithu@gmail.com");
	      user.setPassword("Sweety@10");
	      String uri = "/login";
	      
	      String inputJson = super.mapToJson(user);
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	       .contentType(MediaType.APPLICATION_JSON_VALUE)
	       .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      
	      
	   }

}
