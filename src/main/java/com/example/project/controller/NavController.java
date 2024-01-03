package com.example.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.MutualFundModel;
import com.example.project.model.NavModel;
import com.example.project.model.Pricedata1;
import com.example.project.repository.MutualFundRepository;
import com.example.project.repository.NavRepository;
import com.example.project.repository.Pricedata1Repository;
import com.example.project.service.CalculateNav;
import com.example.project.service.StockListService;

@RestController
public class NavController {
	private static final Logger log = Logger.getLogger(NavController.class);
	{
		BasicConfigurator.configure();
	}
	
	static int s=1;
	@Autowired
	public MutualFundRepository mfRepo;
	
	@Autowired 
	public CalculateNav sls;
	
	
	@Autowired
	public NavRepository navrepo;
	
	@GetMapping("/mf/nav")
	public List<NavModel> seeNav()
	{
		List<MutualFundModel>  list=mfRepo.findAll();
	    List<Double> list_n=sls.calculateNav(list);
		List<NavModel> n=new ArrayList<>();
		//List<Double> lists=new ArrayList<>();
		if(list_n.size()==list.size())
		{
			navrepo.deleteAll();
		for(int i=0;i<list_n.size();i++)
     	{
		    list.get(i).getName_of_mf();
    		list_n.get(i);
	    	int num=s++;
            NavModel nm=new NavModel(num,list.get(i).getName_of_mf(),list_n.get(i),"Shiva Dharsaan");
          //  navrepo.save(nm);
            try {
            navrepo.insertNav(num,list.get(i).getName_of_mf(),list_n.get(i),"Shiva Dharsaan",list.get(i).getMf_id());
            }
            catch(Exception e)
            {
            	e.printStackTrace();
            }
            n.add(nm);
		}}
		log.info("Previous day nav of all mutual funds");
		return n;
		
		//return mfRepo.findByNameofshare(name_of_share);
	}
	
	

}
