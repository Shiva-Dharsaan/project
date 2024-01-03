package com.example.project.controller;
import java.util.Optional;
import java.util.logging.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.Login;
//import com.example.project.model.MutualFundModel;
import com.example.project.repository.LoginRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	
	{
		BasicConfigurator.configure();
		
	}

	@Autowired
	public LoginRepository lRepo;
	
	@PostMapping("/CreateAcc")
	public Login addLogin(@RequestBody Login l)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		log.info("User created Successfully :)");
		String pass=passwordEncoder.encode(l.getPassword());
		l.setType("Portfolio-Manager");
		try{
			lRepo.insertLogin(l.getLogin_id(),pass, l.getType(),l.getCreated_by());
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return l;
	}
	@PostMapping("/CreateAcc2")
	public Login addLogin2(@RequestBody Login l)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		log.info("User created Successfully :)");
		String pass=passwordEncoder.encode(l.getPassword());
		l.setType("Investor");
		try{
			lRepo.insertLogin(l.getLogin_id(),pass, l.getType(),l.getCreated_by());
			}
		catch(Exception e){
			e.printStackTrace();
		}
		return l;
	}
	
	@GetMapping("/login/{loginid}/{password}")
	public String loginCheck(@PathVariable("loginid") String loginid,@PathVariable("password") String password)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Optional<Login> l=lRepo.findById(loginid);
		
		if(l.isPresent())
		{
			Login ll=l.get();
			String password1=ll.getPassword();
			if(passwordEncoder.matches(password,password1))
			{
				if(ll.getType().equals("Portfolio-Manager"))
				{
				log.info("Login Successfull :)");
				return "Login Successfull";
				}else {
					log.error("!!!  No such User with "+loginid+ " as loginid  !!!");
					throw new CustomExceptionMessage("No such user");
				}
			}
			else
			{
				log.warn("!!!  Incorrect Password  !!!");
				return "Incorrect Password";
			}
		}
		else
		{
			log.error("!!!  No such User with "+loginid+ " as loginid  !!!");
			throw new CustomExceptionMessage("No such user");
			//return "No Such User";
		}
	}
	@GetMapping("/login2/{loginid}/{password}")
	public String loginCheck2(@PathVariable("loginid") String loginid,@PathVariable("password") String password)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Optional<Login> l=lRepo.findById(loginid);
		
		if(l.isPresent())
		{
			Login ll=l.get();
			String password1=ll.getPassword();
			if(passwordEncoder.matches(password,password1))
			{
				if(ll.getType().equals("Investor"))
				{
				log.info("Login Successfull :)");
				return "Login Successfull";
				}else {
					log.error("!!!  No such User with "+loginid+ " as loginid  !!!");
					throw new CustomExceptionMessage("No such user");
				}
			}
			else
			{
				log.warn("!!!  Incorrect Password  !!!");
				return "Incorrect Password";
			}
		}
		else
		{
			log.error("!!!  No such User with "+loginid+ " as loginid  !!!");
			throw new CustomExceptionMessage("No such user");
			//return "No Such User";
		}
	}

}