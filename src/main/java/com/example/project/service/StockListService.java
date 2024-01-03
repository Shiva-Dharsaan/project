package com.example.project.service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.project.model.Pricedata1;
import com.example.project.repository.Pricedata1Repository;

@Component
public class StockListService {
	//private static final DecimalFormat decfor = new DecimalFormat("0.00");
	@Autowired
	public Pricedata1Repository pdRepo;
	
	public Set<String> stocks()
	{
	    Set<String> st=new HashSet<>();
		List<Pricedata1> list=pdRepo.findAll();
		for(int i=0;i<list.size();i++)
		{
			Pricedata1 pd=list.get(i);
			st.add(pd.getNameofshare());
		}
		
		return st;
	}

}
