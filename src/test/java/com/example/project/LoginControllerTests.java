package com.example.project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Optional;

//import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.project.model.Login;
import com.example.project.repository.LoginRepository;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.project.controller.LoginController;
import com.example.project.model.Login;
import com.example.project.repository.LoginRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest
public class LoginControllerTests{
	@Autowired
	LoginRepository lRepo;
	
	//case 1: test code to ensure there is no null output
	@Test
	public void testMLoginNotNull()
	{
		assertAll("NotNull",
				 () -> assertNotNull(lRepo.findById("Sowmya")),
                 () -> assertNotNull(lRepo.findById("Shiva")),
                 () -> assertNotNull(lRepo.findById("sandip"))
				);
	}
	
	//case 2: validating password
	@Test
	public void testPassword()
	{
		Login l1=lRepo.findById("Sowmya").get();
		Login l2=lRepo.findById("Shiva").get();
		Login l3=lRepo.findById("sandip").get();
		assertAll("NameCheck",
			() -> assertNotEquals("Sowmya",l1.getPassword(),"password is correct"),
			() -> assertNotEquals("Shiva",l2.getPassword(),"password is correct"),
			() -> assertNotEquals("sandip",l3.getPassword(),"password is correct"));

	}
	
	
	//case 3: validating name
//	@Test
//	public void testName()
//	{
//		Login l1=lRepo.findById("Sowmya").get();
//		Login l2=lRepo.findById("Shiva").get();
//		Login l3=lRepo.findById("sandip").get();
//		assertAll("NameCheck",
//			() -> assertNotEquals("Sowmya",l1.getName_of_p(),"name is correct"),
//			() -> assertNotEquals("Shiva Dharsaan",l2.getName_of_p(),"name is correct"),
//			() -> assertNotEquals("Sandip",l3.getName_of_p(),"name is correct"));
//
//	}
	
	//case 4: validating type
	@Test
	public void testType()
	{
		Login l1=lRepo.findById("Sowmya").get();
		Login l2=lRepo.findById("Shiva").get();
		Login l3=lRepo.findById("sandip").get();
		assertAll("Type",
			() -> assertEquals("investor",l1.getType(), "type is correct"),
			() -> assertEquals("Investor",l2.getType(), "type is correct"),
			() -> assertEquals("investor",l3.getType(), "type is correct"));

	}
	
	//case 5: we are validating whether the user is found or not by passsing login_id
	@Test
	public void testUserValid()
	{
		Optional<Login> l=lRepo.findById("Sowmyas4");
		
		Login l1=new Login();
		if(l.isPresent())
		{
			l1=l.get();
		}
		else
		{
			l1=null;
		}
		assertNull(l1);
	}

	
	
}
