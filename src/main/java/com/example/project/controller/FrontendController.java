package com.example.project.controller;

import java.util.Optional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.Login;
import com.example.project.model.MutualFundModel;
import com.example.project.repository.LoginRepository;
import com.example.project.repository.MutualFundRepository;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class FrontendController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	{
		BasicConfigurator.configure();
	}
	
	@Autowired
	public MutualFundRepository mfRepo;
	
	@Autowired
	public LoginRepository lRepo;
	
	
	@RequestMapping("/home")
	public String homePage()
	{
		//mfRepo.save(mf);

        return "homePage";
	}

	@RequestMapping("/newMf")
	public String addMutualFundUI()
	{
        return "test";
	}
	@RequestMapping("/pmLogin")
	public String pmLogin()
	{
        return "pmLogin";
	}
	@RequestMapping("/pmSignUp")
	public String pmSignUp()
	{
        return "pmSignUp";
	}
	@RequestMapping("/investorLogin")
	public String investorLogin()
	{
        return "investorLogin";
	}
	@RequestMapping("/investorSignUp")
	public String investorSignUp()
	{
        return "investorSignUp";
	}
	
	@RequestMapping("/addManager")
	public String addManager(Login l)
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
		return "pmSignUp";
	}
	@RequestMapping("/addInvestor")
	public String addLogin(Login l)
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
		return "investorSignUp";
	}
	@RequestMapping("/pmLoginCheck")
	public String pmLoginCheck(@RequestParam String loginid,@RequestParam String password)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Optional<Login> l=lRepo.findById(loginid);
		
		if(l.isPresent())
		{
			Login ll=l.get();
			String password1=ll.getPassword();
			if(passwordEncoder.matches(password,password1))
			{
				log.info("Login Successfull :)");
				return "pmLogin";
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
	@RequestMapping("/investorLoginCheck")
	public String investorLoginCheck(@RequestParam String loginid,@RequestParam String password)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Optional<Login> l=lRepo.findById(loginid);
		
		if(l.isPresent())
		{
			Login ll=l.get();
			String password1=ll.getPassword();
			if(passwordEncoder.matches(password,password1))
			{
				log.info("Login Successfull :)");
				return "investorLogin";
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

	@RequestMapping("/CreateMf1")
	public String addMftoDb(MutualFundModel mf)
	{
		log.info("Mutual Fund created Sucessfully :)");
		try{
			mfRepo.insertMf(mf.getMf_id(),mf.getName_of_mf(),mf.getEntry_load(),mf.getExit_load(),mf.getExpense_ratio(),mf.getBalance_cash(),mf.getNav(),mf.getTotal_corpus(),mf.getCreated_by());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

        return "test";
	}
	
	

}
