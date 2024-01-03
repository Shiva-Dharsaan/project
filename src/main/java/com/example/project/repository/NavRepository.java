package com.example.project.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

//import com.example.project.model.MutualFundsVsStocks;
import com.example.project.model.NavModel;
//It declares a custom query method findByMutualfund to retrieve a list of entities based on the mutualfund attribute. 

public interface NavRepository extends  JpaRepository<NavModel,Integer> {
	
	List<NavModel> findByMutualfund(String mutualfund);
     	
	@Procedure(procedureName="INSERTNAV")
	
	void insertNav(
			@Param("nav")
			
			double nav,
			
			@Param("mutualfund")
			
			String mutualfund,
			
			@Param("previousDayNav")
			
			double previousDayNav,
	
	       @Param("created_by")
	
	       String created_by,
	
	       @Param("mfid")
	
            int  mfid
            
            );
			

}
