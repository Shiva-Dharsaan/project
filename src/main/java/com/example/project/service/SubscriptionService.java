package com.example.project.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.InvestorVsMf;
import com.example.project.model.MutualFundModel;
import com.example.project.model.NavModel;
import com.example.project.model.THistory;
import com.example.project.repository.InvestorVsMfRepository;
import com.example.project.repository.MutualFundRepository;
import com.example.project.repository.NavRepository;
import com.example.project.repository.TRepository;

@Component
public class SubscriptionService {
	 static int i=2000;
	@Autowired
	public MutualFundRepository mfRepo;
	@Autowired
	public TRepository trepo;
	@Autowired
	public NavRepository navrepo;
	@Autowired
	public InvestorVsMfRepository irepo;
	
	public InvestorVsMf subscription(String loginid,int mfid,double amount,String created_by)
	{
		Optional<MutualFundModel> m=mfRepo.findById(mfid);
		String mfname="";
		int entry_load=0;
		if(m.isPresent())
		{
			MutualFundModel mf=m.get();
			mfname=mf.getName_of_mf();
			entry_load=mf.getEntry_load();
		}
		else
		{
			throw new CustomExceptionMessage("No such mutual fund present");
		}
		List<NavModel> nav=navrepo.findByMutualfund(mfname);
		if(nav.size()==0)
		{
			throw new CustomExceptionMessage("Run the get nav api");
		}
		NavModel nm=nav.get(0);
		double nav1=nm.getPrevious_day_nav();
		double liabilities=(entry_load*amount)/100;
		double f_amount=amount-liabilities;
		if(nav1==0)
		{
			throw new CustomExceptionMessage("Give Weightage to this mutual fund");
		}
		double units=f_amount/nav1;
		int id=i++;
		boolean exists=false;
		List<InvestorVsMf> holdings=irepo.findByNameofinvestor(loginid);
		InvestorVsMf ivm=null;
		for(int i=0;i<holdings.size();i++)
		{
			if(holdings.get(i).getNameofmf().equals(mfname))
			{
				ivm=holdings.get(i);
				exists=true;
				break;
			}
		}
		InvestorVsMf im=new InvestorVsMf(id,loginid,mfname,units,f_amount);
		if(exists)
		{
			ivm.setNoofunits(ivm.getNoofunits()+units);
			ivm.setAmount(ivm.getAmount()+f_amount);
			int investor_id=ivm.getInvestor_id();
			irepo.updateUnitsAndAmount(ivm.getAmount()+f_amount,ivm.getNoofunits()+units,investor_id);
			return ivm;
		}
		else
		{
		String out=	irepo.insertInvestorVsMf(im.getInvestor_id(),im.getNameofinvestor(),im.getNameofmf(),im.getNoofunits(),im.getAmount(),created_by);
		if(!out.equals("success")) {
			throw new CustomExceptionMessage(out);
		}
		}
		String type="Subscription";
		LocalDateTime time=LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
		String time_1 = time.format(format); 
		THistory t=new THistory(id,type,units,f_amount,time_1,loginid,mfname);
		trepo.save(t);
		
		return im;	


	}

}
