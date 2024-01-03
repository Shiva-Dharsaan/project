package com.example.project.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.model.MutualFundModel;
import com.example.project.model.MutualFundsVsStocks;
import com.example.project.model.Pricedata1;
import com.example.project.repository.MfsVsStocksRepository;
import com.example.project.repository.Pricedata1Repository;

@Component
public class CalculateNav {
	@Autowired
	public Pricedata1Repository pdRepo;
	
	@Autowired
	public MfsVsStocksRepository msrepo;
	
	public List<Double> calculateNav(List<MutualFundModel> l)
	{
		List<Double> nl=new ArrayList<>();
		for(int i=0;i<l.size();i++)
		{
			double total_corpus=0.0;
			double balance_cash=0.0;
			int expense_ratio=0;
			double nav=0.0;
			double curr_nav=0.0;
			MutualFundModel mfm=l.get(i);
			int mf_id=l.get(i).getMf_id();
			List<MutualFundsVsStocks>  list=msrepo.findByMfid(mf_id);
			LocalDate date=LocalDate.now();
			date=date.minusDays(1);
			String date_1=date.toString();
			String[] str=date_1.split("-");
			String date_2=str[2]+"-"+str[1]+"-"+str[0];
			 
			double sum=0.0;
			for(int j=0;j<list.size();j++)
			{
				double closing_price=0;
				MutualFundsVsStocks mfs=list.get(j);
				String name_of_share=mfs.getNameofstock();
				List<Pricedata1> pd=pdRepo.findByNameofshare(name_of_share);
				for(int k=0;k<pd.size();k++)
				{
					if(date_2.equals(pd.get(k).getClosingdate()))
					{
						closing_price=pd.get(k).getClosing_price();
					}
				}
				float no_of_units=mfs.getNoofunits();
				sum=(sum+(closing_price*no_of_units));
							
			}
			total_corpus=mfm.getTotal_corpus();
			balance_cash=mfm.getBalance_cash();
			expense_ratio=mfm.getExpense_ratio();
			double liabilities=((expense_ratio*total_corpus)/100)+balance_cash;
			double available_cash=total_corpus-liabilities;
			nav=mfm.getNav();
			double units=available_cash/nav;
			curr_nav=sum/units;
			nl.add(curr_nav);
		}
		return nl;
		
	}


}
