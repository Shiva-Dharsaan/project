package com.example.project.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.controller.LoginController;
import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.InvestorVsMf;
import com.example.project.model.MutualFundModel;
import com.example.project.model.NavModel;
import com.example.project.model.THistory;
import com.example.project.repository.InvestorVsMfRepository;
import com.example.project.repository.MutualFundRepository;
import com.example.project.repository.NavRepository;
import com.example.project.repository.TRepository;

@Transactional
@Component
public class RedemptionService {
	
	@Autowired
	public MutualFundRepository mfRepo;
	@Autowired
	public TRepository trepo;
	@Autowired
	public NavRepository navrepo;
	@Autowired
	public InvestorVsMfRepository imrepo;
	static int i=1;
	
	public InvestorVsMf redemption(String loginid,int mfid,double units)
	{ 
		final Logger log=Logger.getLogger(LoginController.class);
		
		{
			BasicConfigurator.configure();
			
		}
		double sum=0.0;
		double initial_units=1.0;
		List<InvestorVsMf> list=imrepo.selectInvestorMF(loginid);
		
		Optional<MutualFundModel> m=mfRepo.findById(mfid);
		String mfname="";
		int exit_load=0;
		if(m.isPresent())
		{
			MutualFundModel mf=m.get();
			mfname=mf.getName_of_mf();
			for(int i=0;i<list.size();i++)
			{
				InvestorVsMf imf=list.get(i);
				if(mfname.equals(imf.getNameofmf()))
				{
					sum+=imf.getNoofunits();
				}
			}
			exit_load=mf.getExit_load();
		}
		
		else {
			throw new CustomExceptionMessage("No such mutual fund present");
		}
		log.info(sum);
		if(units>sum)
		{
			throw new CustomExceptionMessage("Insuffiecient Units");
		}
		List<NavModel> nav=navrepo.findByMutualfund(mfname);
		NavModel nm=nav.get(nav.size()-1);
		List<InvestorVsMf> ivm=imrepo.selectInvestorMF(loginid);
		for(int j=0;j<ivm.size();j++)
		{
			if(ivm.get(j).getNameofmf().equals(mfname))
			{
				initial_units=ivm.get(j).getNoofunits();
			}
		}
		double nav1=nm.getPrevious_day_nav();
		double amount=nav1*units;
		double liabilities=(exit_load*amount)/100;
		double f_amount=amount-liabilities;
		int id=i++;
		List<InvestorVsMf> holdings=imrepo.findByNameofinvestor(loginid);
		InvestorVsMf inm=null;
		for(int i=0;i<holdings.size();i++)
		{
			if(holdings.get(i).getNameofmf().equals(mfname))
			{
				inm=holdings.get(i);
				break;
			}
		}
		int investor_id=inm.getInvestor_id();
		imrepo.updateUnitsAndAmount(inm.getAmount()-f_amount,inm.getNoofunits()-units,investor_id);
		InvestorVsMf im=new InvestorVsMf(id,loginid,mfname,units,f_amount);
		String type="Redemption";
		LocalDateTime time=LocalDateTime.now();
		//String time_1=time.toString();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
		String time_1 = time.format(format); 
		THistory t=new THistory(id,type,units,f_amount,time_1,loginid,mfname);
		trepo.save(t);
		
		return im;	

	}

}
