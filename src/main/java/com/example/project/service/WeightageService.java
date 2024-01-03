package com.example.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.controller.LoginController;
import com.example.project.exceptions.CustomExceptionMessage;
import com.example.project.model.MutualFundModel;
import com.example.project.model.MutualFundsVsStocks;
import com.example.project.model.Pricedata1;
import com.example.project.repository.MfsVsStocksRepository;
import com.example.project.repository.MutualFundRepository;
import com.example.project.repository.Pricedata1Repository;


@Component
public class WeightageService {
	
	@Autowired
	public MfsVsStocksRepository msrepo;
	
	@Autowired
	public MutualFundRepository mfRepo;

	@Autowired
	public Pricedata1Repository pdRepo;
	
	public float stockWeightage(int mf_id,String name_of_share,String date,int weightage)
	{
final Logger log=Logger.getLogger(LoginController.class);
		
		{
			BasicConfigurator.configure();
			
		} 
		
		double total_corpus=0.0;
		double balance_cash=0.0;
		int expense_ratio=0;
		int weightage_sum=0;
		int available_weightage=0;
		double cp=1.0;
		float units=(float) 0.0;
		List<MutualFundsVsStocks> list_1=msrepo.findByMfid(mf_id);
		for(int i=0;i<list_1.size();i++)
		{
			MutualFundsVsStocks mfs=list_1.get(i);
			weightage_sum+=mfs.getWeightage();
		}
		log.info(weightage_sum+weightage);
		if(weightage_sum+weightage>100)
		{
			throw new CustomExceptionMessage("Weightage exceeds 100%");
		}
		
		Optional<MutualFundModel> mf=mfRepo.findById(mf_id);
		List<Pricedata1> list=new ArrayList<>();
		System.out.println(total_corpus);
		if(mf.isPresent())
		{
			MutualFundModel mf1=mf.get();
			total_corpus=mf1.getTotal_corpus();
			balance_cash=mf1.getBalance_cash();
			expense_ratio=mf1.getExpense_ratio();
			available_weightage=mf1.getAvailable_weightage();
			
		}
		System.out.print("Shiva");
		double liabilities=((expense_ratio*total_corpus)/100)+balance_cash;
		double available_cash=total_corpus-liabilities;
		 list=pdRepo.findByNameofshare(name_of_share);
		 for(int i=0;i<list.size();i++)
		 {
			 String[] str=date.split("-");
			 String date_1=str[2]+"-"+str[1]+"-"+str[0];
			 if(date_1.equals(list.get(i).getClosingdate()))
			 {
				 System.out.print("Shiva");
				 cp=list.get(i).getClosing_price();
				 break;
			  }
		 }
		 units= (float) ((float)((available_cash*weightage)/100)/cp);
		 
		 return units;
		
		
	}


}
