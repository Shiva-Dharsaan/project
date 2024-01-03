package com.example.project.controller;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.InvestorVsMf;
import com.example.project.model.Login;
import com.example.project.model.MutualFundModel;
//import com.example.project.model.Login;
import com.example.project.ord.Redemption;
import com.example.project.ord.Subscription;
import com.example.project.repository.InvestorVsMfRepository;
import com.example.project.repository.LoginRepository;
//import com.example.project.repository.LoginRepository;
import com.example.project.repository.MutualFundRepository;
import com.example.project.repository.NavRepository;
import com.example.project.repository.TRepository;
import com.example.project.service.RedemptionService;
import com.example.project.service.SubscriptionService;

@RestController
public class InvestorVsMfController {
	
	private static final Logger log = Logger.getLogger(LoginController.class);
	{
		BasicConfigurator.configure();
	}
	
	static int i=1000;
	@Autowired
	public LoginRepository lRepo;
	@Autowired
	public MutualFundRepository mfRepo;
	@Autowired
	public TRepository trepo;
	@Autowired
	public InvestorVsMfRepository irepo;
	@Autowired
	public NavRepository navrepo;
	@Autowired
	public RedemptionService rem;
	@Autowired
	public SubscriptionService sub;
	
	
	@Autowired
	public InvestorVsMfRepository imrepo;
	
	@Transactional
	@GetMapping("/currentholdings/{investor}")
	public List<InvestorVsMf> seeCurrentholding(@PathVariable("investor")  String investor)
	{
		//List<InvestorVsMf> l=new ArrayList<>();
		if(irepo.findByNameofinvestor(investor).isEmpty())
		{
			log.info("No investor with the name"+investor);	
			throw new CustomExceptionMessage("No such investor exists");
			
		}
		else {
		      log.info("Seeing current holding of "+investor);
		}
		//CallableStatementCreator cst = new CallableStatementCreator;
		//List<Object > obj=irepo.fetchFromImf(investor);
//		for(Object b:obj)
//		{
//		    InvestorVsMf im=(InvestorVsMf)b;
//		    l.add(im);
//			System.out.println(im);
//		}
//		
	//	return irepo.fetchFromImf(investor);
		//return irepo.findByNameofinvestor(investor);
		return irepo.selectInvestorMF(investor);
	}
	
	@PostMapping("/subscription")
	public InvestorVsMf subscription(@RequestBody Subscription s)
	{
		
		String loginid=s.getLogind();
		int mfid=s.getMfid();
		Login l=lRepo.findById(loginid).get();
		String created_by=l.getCreated_by();
		double amount=s.getAmount();
		InvestorVsMf im=sub.subscription(loginid, mfid, amount,created_by)	;
		log.info("Subscribing to a Mutual Fund");
		
		//irepo.insertInvestorVsMf(im.getInvestor_id(),im.getNameofinvestor(),im.getNameofmf(),im.getNoofunits(),im.getAmount(),created_by);
		MutualFundModel mf=mfRepo.findById(mfid).get();
		double f_total_corpus=mf.getTotal_corpus()+amount;
		mfRepo.updateTotalCorpus(f_total_corpus,mf.getCreated_by(),mfid);
		return im;
	}
	
	@PostMapping("/redemption")
	public InvestorVsMf redemption(@RequestBody Redemption r)
	{
		
		String loginid=r.getLoginid();
		int mfid=r.getMfid();
		double units=r.getUnits();
		//Login l=lRepo.findById(loginid).get();
		//String created_by=l.getCreated_by();
		InvestorVsMf im=rem.redemption(loginid,mfid,units);
		log.info("Redeeming from a Mutual Fund");
		//irepo.insertInvestorVsMf(im.getInvestor_id(),im.getNameofinvestor(),im.getNameofmf(),im.getNoofunits(),im.getAmount(),created_by)
		//String out=	irepo.insertInvestorVsMf(im.getInvestor_id(),im.getNameofinvestor(),im.getNameofmf(),im.getNoofunits(),im.getAmount(),created_by);
		///	if(!out.equals("success")) {
			//	throw new CustomExceptionMessage(out);
		//	}
		MutualFundModel mf=mfRepo.findById(mfid).get();
		double f_total_corpus=mf.getTotal_corpus()-im.getAmount();
		mfRepo.updateTotalCorpus(f_total_corpus,mf.getCreated_by(),mfid);
		return im;	

	}
    
	@PutMapping("/updateAmountAndUnits/{amount}/{units}/{investor_id}")
	public InvestorVsMf updateAmountAndUnits(@PathVariable("amount")  double amount,@PathVariable("units")  double units,@PathVariable("investor_id") int investor_id)
	{
		irepo.updateUnitsAndAmount(amount, units, investor_id);
		
		return irepo.findById(investor_id).get();
	}

}
