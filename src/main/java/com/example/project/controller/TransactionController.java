package com.example.project.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.THistory;
import com.example.project.repository.TRepository;

@RestController
public class TransactionController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	{
		BasicConfigurator.configure();
	}
	
	@Autowired
	public TRepository trepo;
	
	@GetMapping("/transaction/{nameofinv}")
	public List<THistory> seeTransactionHistory(@PathVariable("nameofinv")  String nameofinv)
	{
		List<THistory> list =trepo.findByInvestorid(nameofinv);
		if(list.isEmpty())
		{
			log.info("No transactions for the user"+nameofinv);
			throw new CustomExceptionMessage("No user found with this name");
		}
		else
		{
			log.info("Showing Transaction History of "+nameofinv);
		}
		
		return list;
	}
	

}
