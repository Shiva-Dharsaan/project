package com.example.project.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.Pricedata1;
import com.example.project.repository.Pricedata1Repository;
import com.example.project.service.StockListService;

@RestController
public class PricedataController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	{
		BasicConfigurator.configure();
	}
	
	@Autowired
	public Pricedata1Repository mfRepo;
	
	@Autowired
	public StockListService sts;
	
	@PostMapping("/CreateStocks")
	public Pricedata1 addmutualfund(@RequestBody Pricedata1 pd)
	{
		log.info("Creating a new Stock");
		return mfRepo.save(pd);
	}
	
	@GetMapping("/ViewStocks/list")
	public Set<String> seeStocks()
	{
		log.info("Getting the list of all Stocks");
		return sts.stocks();
	}
	
	@GetMapping("/ClosingPrice/list/{name_of_share}")
	public List<Pricedata1> seeClosingPrice(@PathVariable("name_of_share")  String name_of_share)
	{
		if(mfRepo.findByNameofshare(name_of_share).isEmpty())
		{
			log.error("No stock with the name "+name_of_share);
			throw new CustomExceptionMessage("No stock with such a name");
		}
		else
		{
			log.info("Returning closing price of "+name_of_share+ " Stock");
		}
		return mfRepo.findByNameofshare(name_of_share);
	}
	
	@GetMapping("/ClosingDate/list")
	public List<Pricedata1> getTodayList()
	{
		LocalDate date=LocalDate.now();
		date=date.minusDays(1);
		String date_1=date.toString();
		String[] str=date_1.split("-");
	    String date_f=str[2]+"-"+str[1]+"-"+str[0];
		 
		return mfRepo.findByClosingdate(date_f);
	}
//	
//	
//	

}
