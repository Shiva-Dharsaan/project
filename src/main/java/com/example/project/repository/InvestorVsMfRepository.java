package com.example.project.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.example.project.model.InvestorVsMf;

//This interface indicates that it will be used to manage entities of type InvestorVsMf with integer primary keys.

@Transactional
public interface InvestorVsMfRepository extends JpaRepository<InvestorVsMf,Integer>
{
	//This interface defines a Spring Data JPA repository for the InvestorVsMf entity.
	//It includes a query method named findByNameofinvestor that allows you to retrieve a list of InvestorVsMf entities based on the name_of_investor attribute. 
		
	List<InvestorVsMf> findByNameofinvestor(String name_of_investor);

	@Procedure(name=InvestorVsMf.namedQuery_insertIVsMf)
	
	String insertInvestorVsMf(
			@Param("investorId")
			int investorId,
			@Param("nameOfInvestor")
			String nameofinvestor,
			@Param("nameOfMf")
			String nameofmf,
			@Param ("noOfUnits")
			double noofunits,
			@Param ("amount")
			double amount,
			@Param ("created_by")
			String created_by);
	
	@Transactional
	@Procedure(name=InvestorVsMf.namedQuery_selectInvestorMf)
	List<InvestorVsMf> selectInvestorMF(@Param("ID") String id);
	
	@Procedure(procedureName="UPDATEAMOUNTANDUNITS")
	void updateUnitsAndAmount(

            @Param("f_amount")
		    
            double amount,

            @Param("units")

		    double units,
			
		    @Param("investorId")

		    int investor_id

			);

	
	
}
