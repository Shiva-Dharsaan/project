package com.example.project.controller;

import java.time.LocalDate;

import java.util.List;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.MutualFundModel;
import com.example.project.model.MutualFundsVsStocks;
import com.example.project.model.Pricedata1;
import com.example.project.ord.StockSelection;
import com.example.project.repository.MfsVsStocksRepository;
import com.example.project.repository.MutualFundRepository;
import com.example.project.service.StockListService;
import com.example.project.service.WeightageService;

@CrossOrigin(origins = "http://localhost:4200")

@RestController
public class MfsVsStocksController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	{
		BasicConfigurator.configure();
	}
	
	@Autowired 
	public WeightageService sls;
	@Autowired
	public MfsVsStocksRepository msrepo;
	@Autowired
	public MutualFundRepository mfRepo;
	
	@GetMapping("/StocksInMf/{mfid}")
	public List<MutualFundsVsStocks> seeStockPortfolio(@PathVariable("mfid")  int mfid)
	{
		if(msrepo.findByMfid(mfid).isEmpty())
		{
			log.info("No such mutual fund"+mfid);
			throw new CustomExceptionMessage("No such mutual fund found");
		}
		else
		{
	     	log.info("Seeing stocks held by a Mutual Fund");
		}
		return msrepo.findByMfid(mfid);
	}
	
	@PostMapping("/addStocksToMf")
	public MutualFundsVsStocks addmfstocks(@RequestBody StockSelection ss)
	{
		Random rand = new Random();
		   
        // Generate random integers in range 0 to 999
        int pid = rand.nextInt(10000);
		int mf=ss.getMfid();
		String st=ss.getStockname();
		int weightage=ss.getWeightage();
		System.out.println(weightage);
		LocalDate date=LocalDate.now();
		date=date.minusDays(1);
		String date_1=date.toString();
		//double
		float units=sls.stockWeightage(mf,st,date_1, weightage);
		//float unit=(float)units;
		//double units=Double.parseDouble(unit);
	    if(ss.getCreated_by()==null)
	    {
	    	throw new CustomExceptionMessage("Please Login");
	    }
		MutualFundsVsStocks mfs=new MutualFundsVsStocks(pid,date_1,mf,st,units,weightage,ss.getCreated_by());
		System.out.println(mfs.getCurrdate());
		log.info("Adding stocks to a  Mutual Fund");
		try {
		msrepo.insertMfWeightage(mfs.getPid(), mfs.getCurrdate(), mfs.getMfid(), mfs.getNameofstock(), mfs.getNoofunits(), mfs.getWeightage(),ss.getCreated_by());
		MutualFundModel mf1=mfRepo.findById(mf).get();
		int  available_weightage=mf1.getAvailable_weightage();
		int balance_weightage=available_weightage-weightage;
		mfRepo.updateWeightage(balance_weightage,mf);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return mfs;
		//return msrepo.save(mfs);
		
	}

}
